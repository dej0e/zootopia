package com.teamOne.cs631.models;

import java.sql.Date;
import com.teamOne.cs631.util.PKey;
import lombok.Data;

@Data 
public class Query5Model {
    @PKey
    public Date dateTime;
    public Integer totalRevenue;
}

