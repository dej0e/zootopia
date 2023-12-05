package com.teamOne.cs631.models;

import lombok.Data;

@Data
public class RevenueEvents {
    public String dateTime;
    public Integer revenueId;
    public Double ticketsSold;
    public Double revenue;
}
