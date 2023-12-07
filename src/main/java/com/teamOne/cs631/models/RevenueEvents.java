package com.teamOne.cs631.models;

import lombok.Data;

import java.sql.Date;

@Data
public class RevenueEvents {
    public Date dateTime;
    public Integer revenueId;
    public Double ticketsSold;
    public Double revenue;
}
