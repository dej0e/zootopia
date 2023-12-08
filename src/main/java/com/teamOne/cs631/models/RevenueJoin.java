package com.teamOne.cs631.models;
import lombok.Data;

import java.sql.Date;

@Data
public class RevenueJoin {
    public String Attraction;
    public Integer totalRevenue;
    public Date dateTime;
    public String RevenueSource;
    
}
