package com.teamOne.cs631.service;

import com.teamOne.cs631.models.Building;
import com.teamOne.cs631.service.dao.BuildingDAO;
import lombok.var;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Service
public class BuildingService implements BuildingDAO {

    public static final String TABLE_NAME = "BUILDING";
    @Autowired
    protected DBService dbService;
    private final QueryRunner dbAccess = new QueryRunner();

    @Override
    public Integer insert(Building obj) throws Exception {
        StringBuffer buffer = new StringBuffer();
        buffer.append("INSERT INTO " + TABLE_NAME + " VALUES (");
        try {
            var empClass = Class.forName(Building.class.getName());
            Field[] aClassFields = empClass.getDeclaredFields();
            for (Field f : aClassFields) {
                String fName = f.getName();
                if (f.get(obj) != null) {
                    if (Number.class.isAssignableFrom(f.getType())) {
                        buffer.append(f.get(obj)).append(", ");
                    } else
                        buffer.append("'").append(f.get(obj)).append("'").append(", ");
                } else
                    buffer.append(f.get(obj)).append(", ");

            }
            buffer.replace(buffer.length() - 2, buffer.length(), ") ");
            System.out.println(buffer);

            //Actual SQL Call
            Statement stmt = dbService.connect().createStatement();
            int updatedCount = stmt.executeUpdate(buffer.toString());
            System.out.println("Inserted " + updatedCount + " rows");

            return updatedCount;

        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Integer update(Building obj) throws Exception {
        StringBuffer buffer = new StringBuffer();
        try {
            PreparedStatement preparedStatement = dbService.connect().prepareStatement(
                    "UPDATE " + TABLE_NAME + " SET NAME = ?, TYPE = ? WHERE ID = ?");


            preparedStatement.setObject(3, obj.getId());
            preparedStatement.setObject(1, obj.getName());
            preparedStatement.setObject(2, obj.getType());
            

            //Actual SQL Call
            int updatedCount = preparedStatement.executeUpdate();
            System.out.println("Updated " + updatedCount + " rows");

            return updatedCount;

        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public List<Building> findAll() {
        try {
            String query = "SELECT * FROM " + TABLE_NAME;
            List<Building> objList = dbAccess.query(dbService.connect(), query, new BeanListHandler<>(Building.class));
            return objList;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
