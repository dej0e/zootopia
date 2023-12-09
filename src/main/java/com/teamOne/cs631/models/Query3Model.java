package com.teamOne.cs631.models;

import com.teamOne.cs631.util.PKey;

import lombok.Data;

@Data
public class Query3Model {
    @PKey
    public String Species;
    public Integer Population;
}
