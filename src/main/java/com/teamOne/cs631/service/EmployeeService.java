package com.teamOne.cs631.service;

import com.teamOne.cs631.models.Employee;
import com.teamOne.cs631.models.enums.EmployeeSearchType;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements EmployeeDAO {

    @Autowired
    protected DBService dbService;
    private QueryRunner dbAccess = new QueryRunner();

    @Override
    public Integer insertEmployee(Employee emp) {
        return null;
    }

    @Override
    public boolean updateEmployee(Employee emp) {
        return false;
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
