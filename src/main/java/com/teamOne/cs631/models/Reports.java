package com.teamOne.cs631.models;

import com.teamOne.cs631.util.PKey;
import lombok.Data;

import java.sql.Date;

@Data
public class Reports {
    @PKey
    public Date Date; //DD-MMM-YY
}
