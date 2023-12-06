package com.teamOne.cs631.service.dao;

import com.teamOne.cs631.models.RevenueTypes;


import java.util.List;

public interface RevenueTypeDAO {
    public Integer insert(RevenueTypes emp) throws Exception;
    public Integer update(RevenueTypes emp) throws Exception;
    public List<RevenueTypes> findAll();
}

