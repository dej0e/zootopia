package com.teamOne.cs631.service.dao;

import com.teamOne.cs631.models.Animal;
import com.teamOne.cs631.models.Employee;

import java.util.List;


public interface AnimalDAO {
    public Integer insert(Animal o) throws Exception;

    public Integer update(Animal o) throws Exception;

    public List<Animal> findAll();
}