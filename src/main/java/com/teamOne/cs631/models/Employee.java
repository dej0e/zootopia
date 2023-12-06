package com.teamOne.cs631.models;

import com.teamOne.cs631.util.PKey;
import lombok.Data;

import java.sql.Date;

@Data
public class Employee {
    @PKey
    public Integer id;
    public Date startDate; //DD-MMM-YY
    public String jobType;
    public String first;
    public String last;
    public String minit;
    public String street;
    public String city;
    public String state;
    public String zip;
    public Integer hourlyRateId;
    public Integer supervisorId;
    public Integer concessionRevenueId;
    public Integer zooAdmissionRevenueId;
}
