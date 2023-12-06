package com.teamOne.cs631.service.dao;

import com.teamOne.cs631.models.Building;


import java.util.List;

public interface BuildingDAO {
    public Integer insert(Building obj) throws Exception;
    public Integer update(Building obj) throws Exception;
    public List<Building> findAll();
}






