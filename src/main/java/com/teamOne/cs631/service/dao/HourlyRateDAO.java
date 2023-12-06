package com.teamOne.cs631.service.dao;

import com.teamOne.cs631.models.Employee;
import com.teamOne.cs631.models.HourlyRate;

import java.util.List;

public interface HourlyRateDAO {
    public Integer insert(HourlyRate obj) throws Exception;

    public Integer update(HourlyRate obj) throws Exception;

    public List<HourlyRate> findAll();
}
