package com.teamOne.cs631.service;

import com.teamOne.cs631.models.Employee;
import com.teamOne.cs631.models.enums.EmployeeSearchType;

import java.util.List;

public interface EmployeeDAO {
    public Integer insert(Employee emp) throws Exception;
    public Integer update(Employee emp) throws Exception;
    public List<Employee> findAll();
}
