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
    private String connectionString = "jdbc:oracle:thin:aa3577/Password#007@prophet.njit.edu:1521:course";
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
        if (connection!=null && connection.isClosed())
            connection = DriverManager.getConnection(connectionString);
        return connection;
    }

    @Override
    public void close() throws Exception {
        connection.close();
    }

}
