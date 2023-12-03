package com.teamOne.cs631.models;

import com.teamOne.cs631.models.enums.JobType;
import lombok.Data;

@Data
public class Employee {
    public String SSN;
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
