package com.teamOne.cs631.service;

import com.teamOne.cs631.models.Employee;
import com.teamOne.cs631.models.HourlyRate;
import com.teamOne.cs631.service.dao.EmployeeDAO;
import com.teamOne.cs631.service.dao.HourlyRateDAO;
import com.teamOne.cs631.util.PKey;
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
public class HourlyRateService implements HourlyRateDAO {

    public static final String TABLE_NAME = "HOURLYRATE";
    @Autowired
    protected DBService dbService;
    private final QueryRunner dbAccess = new QueryRunner();

    @Override
    public Integer insert(HourlyRate obj) throws Exception {
        StringBuffer buffer = new StringBuffer();
        buffer.append("INSERT INTO " + TABLE_NAME + " VALUES (");
        try {
            var empClass = Class.forName(Employee.class.getName());
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
    public Integer update(HourlyRate obj) throws Exception {

        try {
            PreparedStatement preparedStatement = dbService.connect().prepareStatement(
                    "UPDATE " + TABLE_NAME + " SET RATE = ? WHERE ID = ?");

            preparedStatement.setObject(1, obj.getRate());
            preparedStatement.setObject(2, obj.getId());

            //Actual SQL Call
            int updatedCount = preparedStatement.executeUpdate();
            System.out.println("Updated " + updatedCount + " rows");
            return updatedCount;

        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public List<HourlyRate> findAll() {
        try {
            String query = "SELECT * FROM " + TABLE_NAME;
            List<HourlyRate> employees = dbAccess.query(dbService.connect(), query, new BeanListHandler<>(HourlyRate.class));
            return employees;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
