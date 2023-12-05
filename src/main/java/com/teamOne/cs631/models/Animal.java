package com.teamOne.cs631.models;

import lombok.Data;

@Data
public class Animal {
    public Integer id;
    public Integer buildingId;
    public Integer speciesId;
    public String status;
    public Integer birthYear;
    public Integer enclosureId;
}
