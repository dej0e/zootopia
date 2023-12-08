package com.teamOne.cs631.models;

import com.teamOne.cs631.util.PKey;
import lombok.Data;

import java.sql.Date;

@Data
public class AnimalJoinSpecies {
    @PKey
    public Integer id;
    public Integer buildingId;
    public Integer speciesId;
    public String status;
    public Date birthYear;
    public Integer enclosureId;
    public String name;
    public Double foodCost;
    
}
