package com.teamOne.cs631.service;

import com.teamOne.cs631.models.Employee;
import com.teamOne.cs631.models.enums.EmployeeSearchType;

import java.util.List;
import java.util.Optional;

public interface EmployeeDAO {
    public Integer insertEmployee(Employee emp);
    public boolean updateEmployee(Employee emp);
    public boolean deleteEmployee(Employee emp);
    public List<Employee> findEmployeeByProperty(EmployeeSearchType searchType, Object value);
    public List<Employee> findAll();
}
