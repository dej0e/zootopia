package com.teamOne.cs631.service.dao;

import com.teamOne.cs631.models.RevenueEvents;
import com.teamOne.cs631.models.RevenueTypes;


import java.util.List;

public interface RevenueTypeDAO {
    public Integer insertRevenueEvents(RevenueEvents emp) throws Exception;

    public Integer insertRevenueTypes(RevenueTypes emp) throws Exception;

    public Integer updateRevenueEvents(RevenueEvents emp) throws Exception;

    public Integer updateRevenueTypes(RevenueTypes emp) throws Exception;

    public List<RevenueTypes> findAllRevenueTypes();

    public List<RevenueEvents> findAllRevenueEvents();

}

