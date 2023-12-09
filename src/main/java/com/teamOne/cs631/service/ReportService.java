package com.teamOne.cs631.service;


import com.teamOne.cs631.models.Query1Model;
import com.teamOne.cs631.models.Query3Model;
import com.teamOne.cs631.models.Query4Model;
import com.teamOne.cs631.models.Query5Model;
import com.teamOne.cs631.models.Query6Model;


import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class ReportService {
    @Autowired
    protected DBService dbService;
    private final QueryRunner dbAccess = new QueryRunner();
    
    public List<Query1Model> query1findAll(LocalDate date) {
        String query;
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd-MMM-yy");
        String outputDateString = date.format(outputFormatter);
        System.out.println("WITHIN FUNC: "+outputDateString);
        List<Query1Model> rev;
        try {
                query = "SELECT re.dateTime AS eventDate,rt.name AS event,re.ticketsSold AS ticketsSold,re.revenue AS totalRevenue FROM Revenue_Events re JOIN Revenue_Types rt ON re.revenueId = rt.revenueTypeId JOIN Concession cn ON rt.revenueTypeId = cn.revenueId WHERE re.dateTime = '"+outputDateString+"'";
                rev = dbAccess.query(dbService.connect(), query, new BeanListHandler<>(Query1Model.class));
                System.out.println(rev);
                return rev;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
    
    public List<Query3Model> query3findAll() {
        String query;
        List<Query3Model> rev;
        try {

            
                query = "SELECT s.name AS species,a.status,COUNT(a.id) AS animalCount,SUM(s.foodCost) AS totalFoodCost,SUM(CASE WHEN e.jobType = 'Veterinarian' THEN hr.RATE * 40 * 4 ELSE 0 END) AS VetCost,SUM(CASE WHEN e.jobType = 'Animal Care Specialist' THEN hr.RATE * 40 * 4 ELSE 0 END) AS ACSpecialistCost FROM ANIMAL a JOIN SPECIES s ON a.speciesId = s.id JOIN Cares_For cf ON a.speciesId = cf.speciesId JOIN EMPLOYEE e ON cf.employeeId = e.id JOIN AA3577.HOURLYRATE hr ON e.HOURLYRATEID = hr.ID GROUP BY s.name,a.status";
                rev = dbAccess.query(dbService.connect(), query, new BeanListHandler<>(Query3Model.class));
                System.out.println(rev);
                return rev;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
    public List<Query4Model> query4findAll(LocalDate startDate,LocalDate endDate) {
        String query;
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd-MMM-yy");
        String outputstartDateString = startDate.format(outputFormatter);
        String outputendDateString = endDate.format(outputFormatter);
        System.out.println("WITHIN FUNC: StartDate"+outputstartDateString);
        System.out.println("WITHIN FUNC: EndDate"+outputendDateString);
        List<Query4Model> rev;
        try {
            
                query = "SELECT r.name AS attraction, SUM(revenue) AS totalRevenue FROM Revenue_Events re JOIN Revenue_Types r ON re.revenueId = r.revenueTypeId WHERE re.datetime  BETWEEN '"+outputstartDateString+"' AND '"+outputendDateString+"' GROUP BY r.name ORDER BY totalRevenue DESC FETCH FIRST 3 ROWS ONLY";
                rev = dbAccess.query(dbService.connect(), query, new BeanListHandler<>(Query4Model.class));
                System.out.println(rev);
                return rev;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
    public List<Query5Model> query5findAll(LocalDate startDate,LocalDate endDate) {
        String query;
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd-MMM-yy");
        String outputstartDateString = startDate.format(outputFormatter);
        String outputendDateString = endDate.format(outputFormatter);
        System.out.println("WITHIN FUNC: StartDate"+outputstartDateString);
        System.out.println("WITHIN FUNC: EndDate"+outputendDateString);
        
        List<Query5Model> rev;
        try {
            
                query =  "SELECT dateTime , SUM(revenue) AS totalRevenue FROM Revenue_Events WHERE TRUNC(dateTime) BETWEEN '"+outputstartDateString+"' AND '"+outputendDateString+"' GROUP BY dateTime ORDER BY totalRevenue DESC FETCH FIRST 5 ROWS ONLY";
                rev = dbAccess.query(dbService.connect(), query, new BeanListHandler<>(Query5Model.class));
                System.out.println(rev);
                return rev;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
    public List<Query6Model> query6findAll(LocalDate startDate,LocalDate endDate) {
        String query;
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd-MMM-yy");
        String outputstartDateString = startDate.format(outputFormatter);
        String outputendDateString = endDate.format(outputFormatter);
        System.out.println("WITHIN FUNC: StartDate"+outputstartDateString);
        System.out.println("WITHIN FUNC: EndDate"+outputendDateString);
        List<Query6Model> rev;
        try {
            

                query =  "SELECT rt.name AS revenueSource,ROUND(AVG(re.revenue), 2) AS averageRevenue,SUM(re.ticketsSold) AS totalAttendance FROM Revenue_Types rt JOIN Revenue_Events re ON rt.revenueTypeId = re.revenueId WHERE re.dateTime BETWEEN '"+outputstartDateString+"' AND '"+outputendDateString+"' GROUP BY rt.name ORDER BY AverageRevenue DESC";
                rev = dbAccess.query(dbService.connect(), query, new BeanListHandler<>(Query6Model.class));
                System.out.println(rev);
                return rev;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
    
    
}
