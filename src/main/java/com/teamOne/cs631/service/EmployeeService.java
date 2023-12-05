package com.teamOne.cs631.service;

import com.teamOne.cs631.models.Employee;
import com.teamOne.cs631.models.enums.EmployeeSearchType;
import com.teamOne.cs631.util.PKey;
import lombok.var;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.sql.Statement;
import java.util.List;

@Service
public class EmployeeService implements EmployeeDAO {

    public static final String TABLE_NAME = "EMPLOYEE";
    @Autowired
    protected DBService dbService;
    private QueryRunner dbAccess = new QueryRunner();

    @Override
    public Integer insertEmployee(Employee obj) throws Exception {
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
                        buffer.append("\'").append(f.get(obj)).append("\'").append(", ");
                } else
                    buffer.append(f.get(obj)).append(", ");

            }
            buffer.replace(buffer.length() - 2, buffer.length(), ") ");
            System.out.println(buffer.toString());

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
    public Integer updateEmployee(Employee obj) throws Exception {
        StringBuffer buffer = new StringBuffer();
        buffer.append("UPDATE " + TABLE_NAME + " SET ");
        try {
            var empClass = Class.forName(Employee.class.getName());
            Object uniqueIdentifier = "";
            String uniqueIdentifierName = "";
            Field[] aClassFields = empClass.getDeclaredFields();
            for (Field f : aClassFields) {
                String fName = f.getName();
                if (f.get(obj) == null)
                    continue;
                if (f.getAnnotation(PKey.class) == null) {
                    if (Number.class.isAssignableFrom(f.getType())) {
                        buffer.append(fName).append(" = ").append(f.get(obj)).append(", ");
                    } else
                        buffer.append(fName).append(" = ").append("\'").append(f.get(obj)).append("\'").append(", ");
                } else {
                    uniqueIdentifierName = f.getName();
                    if (Number.class.isAssignableFrom(f.getType())) {
                        uniqueIdentifier = f.get(obj);
                    } else {
                        uniqueIdentifier = "\'" + f.get(obj).toString() + "\'";
                    }

                }
            }
            buffer.replace(buffer.length() - 2, buffer.length(), " ");
            buffer.append("WHERE ").append(uniqueIdentifierName).append(" = ").append(uniqueIdentifier);
            System.out.println(buffer.toString());

            //Actual SQL Call
            Statement stmt = dbService.connect().createStatement();
            int updatedCount = stmt.executeUpdate(buffer.toString());
            System.out.println("Updated " + updatedCount + " rows");

            return updatedCount;

        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public boolean deleteEmployee(Employee emp) {
        return false;
    }

    @Override
    public List<Employee> findEmployeeByProperty(EmployeeSearchType searchType, Object value) {
        return null;
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
