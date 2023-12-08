package com.teamOne.cs631.service;


import com.teamOne.cs631.models.Animal;
import com.teamOne.cs631.models.AnimalJoinSpecies;
import com.teamOne.cs631.models.RevenueEvents;
import com.teamOne.cs631.models.RevenueJoin;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.joda.DateTimeParser;
import org.springframework.stereotype.Service;

import java.security.Timestamp;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class ReportService {

    
    @Autowired
    protected DBService dbService;
    private final QueryRunner dbAccess = new QueryRunner();
    
    public List<RevenueEvents> findAll(LocalDate date,int queryNo) {
        String query;
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd-MMM-yy");
        String outputDateString = date.format(outputFormatter);
        System.out.println("WITHIN FUNC: "+outputDateString);
        List<RevenueEvents> rev;
        try {
            if(queryNo==1){
                query = "SELECT dateTime, COUNT(*) AS ActivityCount FROM Revenue_Events WHERE dateTime ='"+outputDateString+"' GROUP BY dateTime";
                rev = dbAccess.query(dbService.connect(), query, new BeanListHandler<>(RevenueEvents.class));
                System.out.println(dbAccess.query(dbService.connect(), query, new BeanListHandler<>(RevenueEvents.class)));
            }else if(queryNo==5){
                query = "SELECT dateTime , SUM(revenue) AS totalRevenue FROM Revenue_Events WHERE TRUNC(dateTime)= '"+outputDateString+"' GROUP BY dateTime ORDER BY totalRevenue DESC FETCH FIRST 5 ROWS ONLY";
                rev = dbAccess.query(dbService.connect(), query, new BeanListHandler<>(RevenueEvents.class));
                System.out.println(dbAccess.query(dbService.connect(), query, new BeanListHandler<>(RevenueEvents.class)));
            }else if(queryNo==6){
                query = "SELECT AVG(revenue) AS averageRevenue FROM Revenue_Events WHERE dateTime = '"+outputDateString+"'";
                rev = dbAccess.query(dbService.connect(), query, new BeanListHandler<>(RevenueEvents.class));
                System.out.println(dbAccess.query(dbService.connect(), query, new BeanListHandler<>(RevenueEvents.class)));
            }else{
                rev=null;;
            }
            return rev;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
    public List<RevenueJoin> findAll2(LocalDate date,int queryNo) {
        String query;
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd-MMM-yy");
        String outputDateString = date.format(outputFormatter);
        System.out.println("WITHIN FUNC: "+outputDateString);
        List<RevenueJoin> rev;
        try {
            if(queryNo==2){
                query = "SELECT R.dateTime, RT.name AS RevenueSource, SUM(R.revenue) AS TotalRevenue FROM Revenue_Events R JOIN Revenue_Types RT ON R.revenueId = RT.revenueTypeId WHERE R.dateTime = '"+outputDateString+"' GROUP BY R.dateTime, RT.name";
                rev = dbAccess.query(dbService.connect(), query, new BeanListHandler<>(RevenueJoin.class));
                System.out.println(dbAccess.query(dbService.connect(), query, new BeanListHandler<>(RevenueJoin.class)));
                
            }else if(queryNo==4){
                query = "SELECT r.name AS attraction, SUM(revenue) AS totalRevenue FROM Revenue_Events re JOIN Revenue_Types r ON re.revenueId = r.revenueTypeId WHERE re.datetime = '"+outputDateString+"' GROUP BY r.name ORDER BY totalRevenue DESC FETCH FIRST 3 ROWS ONLY";
                rev = dbAccess.query(dbService.connect(), query, new BeanListHandler<>(RevenueJoin.class));
                System.out.println(dbAccess.query(dbService.connect(), query, new BeanListHandler<>(RevenueJoin.class)));
                

            }else{
                rev=null;;
            }
            return rev;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
    public List<AnimalJoinSpecies> findAll3() {
        String query;
        List<AnimalJoinSpecies> rev;
        try {
            query ="SELECT s.name AS Species, COUNT(*) AS Population FROM ANIMAL a JOIN SPECIES s ON a.speciesId = s.id GROUP BY s.name";
            rev = dbAccess.query(dbService.connect(), query, new BeanListHandler<>(AnimalJoinSpecies.class));
            System.out.println(dbAccess.query(dbService.connect(), query, new BeanListHandler<>(AnimalJoinSpecies.class)));
            return rev;

        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}
