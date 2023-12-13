

package com.teamOne.cs631.service;

import com.teamOne.cs631.models.Animal;
import com.teamOne.cs631.models.Employee;
import com.teamOne.cs631.service.dao.AnimalDAO;
import lombok.var;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class AnimalService implements AnimalDAO {

    public static final String TABLE_NAME = "ANIMAL";
    @Autowired
    protected DBService dbService;
    private final QueryRunner dbAccess = new QueryRunner();

    @Override
    public Integer insert(Animal obj) throws Exception {
        StringBuffer buffer = new StringBuffer();
        buffer.append("INSERT INTO " + TABLE_NAME + " VALUES (");
        try {
            var empClass = Class.forName(Animal.class.getName());
            Field[] aClassFields = empClass.getDeclaredFields();
            for (Field f : aClassFields) {
                String fName = f.getName();
                if (f.get(obj) != null) {

                    if(fName.toLowerCase().contains("date") || fName.toLowerCase().contains("year")) {
                        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd-MMM-yy");
                        String outputDateString = ((Date)f.get(obj)).toLocalDate().format(outputFormatter);
                        System.out.println("WITHIN FUNC: "+outputDateString);
                        buffer.append("'").append(outputDateString).append("'").append(", ");

                    } else  if (Number.class.isAssignableFrom(f.getType())) {
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
    public Integer update(Animal obj) throws Exception {
        StringBuffer buffer = new StringBuffer();
        try {
            PreparedStatement preparedStatement = dbService.connect().prepareStatement(
                    "UPDATE " + TABLE_NAME + " SET BUILDINGID = ?, SPECIESID = ?, STATUS = ?, BIRTHYEAR = ?, ENCLOSUREID = ? WHERE ID = ?");


            preparedStatement.setObject(1, obj.getBuildingId());
            preparedStatement.setObject(2, obj.getSpeciesId());
            preparedStatement.setObject(3, obj.getStatus());
            preparedStatement.setDate(4, obj.getBirthYear());
            preparedStatement.setObject(5, obj.getEnclosureId());
            preparedStatement.setObject(6, obj.getId());

            //Actual SQL Call
            int updatedCount = preparedStatement.executeUpdate();
            System.out.println("Updated " + updatedCount + " rows");

            return updatedCount;

        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public List<Animal> findAll() {
        try {
            String query = "SELECT * FROM " + TABLE_NAME;
            List<Animal> objList = dbAccess.query(dbService.connect(), query, new BeanListHandler<>(Animal.class));
            return objList;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
