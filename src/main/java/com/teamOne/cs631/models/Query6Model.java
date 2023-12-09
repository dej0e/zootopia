package com.teamOne.cs631.models;
import java.sql.Date;
import com.teamOne.cs631.util.PKey;
import lombok.Data;
@Data 
public class Query6Model {
    @PKey
    public String revenueSource;
    public Integer averageRevenue;
    public Integer totalAttendance;
}

