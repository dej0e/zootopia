package com.teamOne.cs631.models;
import java.sql.Date;

import com.teamOne.cs631.util.PKey;

import lombok.Data;

@Data
public class Query1Model {
    @PKey
    public Date dateTime;
    public Integer ActivityCount;
}
