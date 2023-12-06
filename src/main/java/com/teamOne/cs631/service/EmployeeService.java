package com.teamOne.cs631.service;

import com.teamOne.cs631.models.Employee;
import com.teamOne.cs631.service.dao.EmployeeDAO;
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
public class EmployeeService implements EmployeeDAO {

    public static final String TABLE_NAME = "EMPLOYEE";
    @Autowired
    protected DBService dbService;
    private final QueryRunner dbAccess = new QueryRunner();

    @Override
    public Integer insert(Employee obj) throws Exception {
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
    public Integer update(Employee obj) throws Exception {
//        StringBuffer buffer = new StringBuffer();
//        buffer.append("UPDATE " + TABLE_NAME + " SET ");
//        try {
//            var empClass = Class.forName(Employee.class.getName());
//            Object uniqueIdentifier = "";
//            String uniqueIdentifierName = "";
//            Field[] aClassFields = empClass.getDeclaredFields();
//            for (Field f : aClassFields) {
//                String fName = f.getName();
//                if (f.get(obj) == null)
//                    continue;
//                if (f.getAnnotation(PKey.class) == null) {
//                    if (Number.class.isAssignableFrom(f.getType())) {
//                        buffer.append(fName).append(" = ").append(f.get(obj)).append(", ");
//                    } else
//                        buffer.append(fName).append(" = ").append("'").append(f.get(obj)).append("'").append(", ");
//                } else {
//                    uniqueIdentifierName = f.getName();
//                    if (Number.class.isAssignableFrom(f.getType())) {
//                        uniqueIdentifier = f.get(obj);
//                    } else {
//                        uniqueIdentifier = "'" + f.get(obj).toString() + "'";
//                    }
//
//                }
//            }
//            buffer.replace(buffer.length() - 2, buffer.length(), " ");
//            buffer.append("WHERE ").append(uniqueIdentifierName).append(" = ").append(uniqueIdentifier);
//            System.out.println(buffer);
        try {
            PreparedStatement preparedStatement = dbService.connect().prepareStatement(
                    "UPDATE " + TABLE_NAME + " SET STARTDATE = ?, JOBTYPE = ?, FIRST = ?, LAST = ?, MINIT = ?, STREET = ?, CITY = ?, STATE = ?, ZIP = ?, HOURLYRATEID = ?, SUPERVISORID = ?, CONCESSIONREVENUEID = ?, ZOOADMISSIONREVENUEID = ? WHERE ID = ?");

            preparedStatement.setDate(1, obj.getStartDate());
            preparedStatement.setObject(2, obj.getJobType());
            preparedStatement.setObject(3, obj.getFirst());
            preparedStatement.setObject(4, obj.getLast());
            preparedStatement.setObject(5, obj.getMinit());
            preparedStatement.setObject(6, obj.getStreet());
            preparedStatement.setObject(7, obj.getCity());
            preparedStatement.setObject(8, obj.getState());
            preparedStatement.setObject(9, obj.getZip());
            preparedStatement.setObject(10, obj.getHourlyRateId());
            preparedStatement.setObject(11, obj.getSupervisorId());
            preparedStatement.setObject(12, obj.getConcessionRevenueId());
            preparedStatement.setObject(13, obj.getZooAdmissionRevenueId());
            preparedStatement.setObject(14, obj.getId());

            //Actual SQL Call
            int updatedCount = preparedStatement.executeUpdate();
            System.out.println("Updated " + updatedCount + " rows");
            return updatedCount;

        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public List<Employee> findAll() {
        try {
            String query = "SELECT * FROM EMPLOYEE";
            List<Employee> employees = dbAccess.query(dbService.connect(), query, new BeanListHandler<>(Employee.class));
            return employees;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
