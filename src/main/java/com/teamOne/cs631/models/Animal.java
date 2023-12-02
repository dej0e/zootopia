package com.teamOne.cs631.models;

import lombok.Data;

@Data
public class Animal {
    public Integer ID;
    public Integer buildingId;
    public Integer speciesId;
    public String status;
    public Integer birthYear;
    public Integer EnclosureId;
}
