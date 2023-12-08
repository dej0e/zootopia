package com.teamOne.cs631.service;


import com.teamOne.cs631.models.Query1Model;
import com.teamOne.cs631.models.Query2Model;
import com.teamOne.cs631.models.Query3Model;
import com.teamOne.cs631.models.Query4Model;
import com.teamOne.cs631.models.Query5Model;
import com.teamOne.cs631.models.Query6Model;
// import com.teamOne.cs631.models.Animal;
// import com.teamOne.cs631.models.AnimalJoinSpecies;
// import com.teamOne.cs631.models.RevenueEvents;
// import com.teamOne.cs631.models.RevenueJoin;

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
                query = "SELECT dateTime, COUNT(*) AS ActivityCount FROM Revenue_Events WHERE dateTime ='"+outputDateString+"' GROUP BY dateTime";
                rev = dbAccess.query(dbService.connect(), query, new BeanListHandler<>(Query1Model.class));
                System.out.println(rev);
                return rev;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
    public List<Query2Model> query2findAll(LocalDate date) {
        String query;
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd-MMM-yy");
        String outputDateString = date.format(outputFormatter);
        System.out.println("WITHIN FUNC: "+outputDateString);
        List<Query2Model> rev;
        try {
                query = "SELECT R.dateTime, RT.name AS RevenueSource, SUM(R.revenue) AS TotalRevenue FROM Revenue_Events R JOIN Revenue_Types RT ON R.revenueId = RT.revenueTypeId WHERE R.dateTime = '"+outputDateString+"' GROUP BY R.dateTime, RT.name";
                rev = dbAccess.query(dbService.connect(), query, new BeanListHandler<>(Query2Model.class));
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
                query = "SELECT s.name AS Species, COUNT(*) AS Population FROM ANIMAL a JOIN SPECIES s ON a.speciesId = s.id GROUP BY s.name";
                rev = dbAccess.query(dbService.connect(), query, new BeanListHandler<>(Query3Model.class));
                System.out.println(rev);
                return rev;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
    public List<Query4Model> query4findAll(LocalDate date) {
        String query;
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd-MMM-yy");
        String outputDateString = date.format(outputFormatter);
        System.out.println("WITHIN FUNC: "+outputDateString);
        List<Query4Model> rev;
        try {
                query = "SELECT r.name AS attraction, SUM(revenue) AS totalRevenue FROM Revenue_Events re JOIN Revenue_Types r ON re.revenueId = r.revenueTypeId WHERE re.datetime = '"+outputDateString+"' GROUP BY r.name ORDER BY totalRevenue DESC FETCH FIRST 3 ROWS ONLY";
                rev = dbAccess.query(dbService.connect(), query, new BeanListHandler<>(Query4Model.class));
                System.out.println(rev);
                return rev;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
    public List<Query5Model> query5findAll(LocalDate date) {
        String query;
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd-MMM-yy");
        String outputDateString = date.format(outputFormatter);
        System.out.println("WITHIN FUNC: "+outputDateString);
        List<Query5Model> rev;
        try {
                query =  "SELECT dateTime , SUM(revenue) AS totalRevenue FROM Revenue_Events WHERE TRUNC(dateTime)= '"+outputDateString+"' GROUP BY dateTime ORDER BY totalRevenue DESC FETCH FIRST 5 ROWS ONLY";
                rev = dbAccess.query(dbService.connect(), query, new BeanListHandler<>(Query5Model.class));
                System.out.println(rev);
                return rev;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
    public List<Query6Model> query6findAll(LocalDate date) {
        String query;
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd-MMM-yy");
        String outputDateString = date.format(outputFormatter);
        System.out.println("WITHIN FUNC: "+outputDateString);
        List<Query6Model> rev;
        try {
                query =  "SELECT AVG(revenue) AS averageRevenue FROM Revenue_Events WHERE dateTime = '"+outputDateString+"'";
                rev = dbAccess.query(dbService.connect(), query, new BeanListHandler<>(Query6Model.class));
                System.out.println(rev);
                return rev;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
    
    
}
