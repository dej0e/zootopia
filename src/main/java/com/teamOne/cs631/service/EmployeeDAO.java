package com.teamOne.cs631.service;

import com.teamOne.cs631.models.Employee;
import com.teamOne.cs631.models.enums.EmployeeSearchType;

import java.util.List;

public interface EmployeeDAO {
    public Integer insertEmployee(Employee emp) throws Exception;
    public Integer updateEmployee(Employee emp) throws Exception;
    public boolean deleteEmployee(Employee emp);
    public List<Employee> findEmployeeByProperty(EmployeeSearchType searchType, Object value);
    public List<Employee> findAll();
}
