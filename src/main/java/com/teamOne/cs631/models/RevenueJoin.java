package com.teamOne.cs631.models;
import lombok.Data;

import java.sql.Date;

@Data
public class RevenueJoin {
    public Date dateTime;
    public Integer revenueId;
    public Double ticketsSold;
    public Double revenue;
    public String name;
    public String type;
    public Integer buildingId;
}
