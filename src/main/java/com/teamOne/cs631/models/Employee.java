package com.teamOne.cs631.models;

import lombok.Data;

@Data
public class Employee {
    public Integer ID;
    public String startDate;
    public JobType jobType;
    public String first;
    public String last;
    public String minit;
    public String street;
    public String city;
    public String state;
    public String zip;
    public String hourlyRateId;
    public Integer supervisorId;
    public Integer concessionRevenueId;
    public Integer zooAdmissionRevenueId;
}
