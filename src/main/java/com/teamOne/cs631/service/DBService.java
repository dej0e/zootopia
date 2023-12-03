package com.teamOne.cs631.service;

import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
public class DBService implements DAO {
    private Connection connection;
    private String connectionString = "jdbc:oracle:thin:dj324/Crunchy!Educator1!Brute@prophet.njit.edu:1521:course";
    @Value("spring.datasource.username")
    private String dbUserName;
    @Value("spring.datasource.password")
    private String dbPw;
    @PostConstruct
    @Override
    public void setup() {
        try {
            connection = DriverManager.getConnection(connectionString);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Connection connect() throws Exception {
        connection = DriverManager.getConnection(connectionString);
        return connection;
    }

    @Override
    public void close() throws Exception {
        connection.close();
    }

}
