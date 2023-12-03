package com.teamOne.cs631.service;

import java.sql.Connection;

public interface DAO {
    public void setup() throws Exception;
    public Connection connect() throws Exception;
    public void close() throws Exception;

}
