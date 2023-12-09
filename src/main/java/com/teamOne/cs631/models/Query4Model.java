package com.teamOne.cs631.models;
import com.teamOne.cs631.util.PKey;
import lombok.Data;

@Data 
public class Query4Model {
    @PKey
    public String attraction;
    public Integer totalRevenue;
}

