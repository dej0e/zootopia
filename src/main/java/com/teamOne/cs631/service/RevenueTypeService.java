package com.teamOne.cs631.service;


import com.teamOne.cs631.models.RevenueEvents;
import com.teamOne.cs631.models.RevenueTypes;
import com.teamOne.cs631.service.dao.RevenueTypeDAO;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.util.List;

@Service
public class RevenueTypeService implements RevenueTypeDAO {

    public static final String REVENUE_TYPES_TABLE_NAME = "Revenue_Types";
    public static final String REVENUE_EVENTS_TABLE_NAME = "Revenue_Events";

    @Autowired
    protected DBService dbService;
    private final QueryRunner dbAccess = new QueryRunner();

    @Override
    public Integer insertRevenueEvents(RevenueEvents obj) throws Exception {

        try {
            PreparedStatement preparedStatement = dbService.connect().prepareStatement(
                    "INSERT INTO " + REVENUE_EVENTS_TABLE_NAME + " VALUES( ?, ?, ?, ?)");

            preparedStatement.setDate(1, obj.getDateTime());
            preparedStatement.setObject(2, obj.getRevenueId());
            preparedStatement.setObject(3, obj.getTicketsSold());
            preparedStatement.setObject(4, obj.getRevenue());

            int updatedCount = preparedStatement.executeUpdate();
            System.out.println("Inserted " + updatedCount + " rows");

            return updatedCount;

        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Integer insertRevenueTypes(RevenueTypes obj) throws Exception {
        try {
            PreparedStatement preparedStatement = dbService.connect().prepareStatement(
                    "INSERT INTO " + REVENUE_TYPES_TABLE_NAME + " VALUES( ?,  ?, ?, ?)");

            preparedStatement.setObject(1, obj.getRevenueTypeId());
            preparedStatement.setObject(2, obj.getName());
            preparedStatement.setObject(3, obj.getType());
            preparedStatement.setObject(4, obj.getBuildingId());


            int updatedCount = preparedStatement.executeUpdate();
            System.out.println("Inserted " + updatedCount + " rows");

            return updatedCount;

        } catch (
                Exception e) {
            throw e;
        }

    }

    public Integer updateRevenueEvents(RevenueEvents obj) throws Exception {
        StringBuffer buffer = new StringBuffer();
        try {
            PreparedStatement preparedStatement = dbService.connect().prepareStatement(
                    "UPDATE " + REVENUE_EVENTS_TABLE_NAME + " SET TICKETSSOLD = ?,REVENUE = ? WHERE DATETIME = ? AND REVENUEID = ?");

            preparedStatement.setObject(1, obj.getTicketsSold());
            preparedStatement.setObject(2, obj.getRevenue());
            preparedStatement.setObject(3, obj.getDateTime());
            preparedStatement.setObject(4, obj.getRevenueId());


            //Actual SQL Call
            int updatedCount = preparedStatement.executeUpdate();
            System.out.println("updateRevenueEvents " + updatedCount + " rows");

            return updatedCount;

        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Integer updateRevenueTypes(RevenueTypes obj) throws Exception {
        StringBuffer buffer = new StringBuffer();
        try {
            PreparedStatement preparedStatement = dbService.connect().prepareStatement(
                    "UPDATE " + REVENUE_TYPES_TABLE_NAME + " SET NAME = ?, TYPE = ?,BUILDINGID =? WHERE REVENUETYPEID = ?");

            preparedStatement.setObject(1, obj.getName());
            preparedStatement.setObject(2, obj.getType());
            preparedStatement.setObject(3, obj.getBuildingId());
            preparedStatement.setObject(4, obj.getRevenueTypeId());

            //Actual SQL Call
            int updatedCount = preparedStatement.executeUpdate();
            System.out.println("updateRevenueTypes " + updatedCount + " rows");

            return updatedCount;

        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public List<RevenueTypes> findAllRevenueTypes() {
        try {
            String query = "SELECT * FROM " + REVENUE_TYPES_TABLE_NAME;
            List<RevenueTypes> objList = dbAccess.query(dbService.connect(), query, new BeanListHandler<>(RevenueTypes.class));
            return objList;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<RevenueEvents> findAllRevenueEvents() {
        try {
            String query = "SELECT * FROM " + REVENUE_EVENTS_TABLE_NAME;
            List<RevenueEvents> objList = dbAccess.query(dbService.connect(), query, new BeanListHandler<>(RevenueEvents.class));
            return objList;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
