package com.apps.quantitymeasurement.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionPool {

    public static Connection getConnection() {
        try {
            String url = PropertyReader.getProperty("db.url");
            String username = PropertyReader.getProperty("db.username");
            String password = PropertyReader.getProperty("db.password");

            return DriverManager.getConnection(url, username, password);

        } catch (Exception e) {
            throw new RuntimeException("Database connection failed", e);
        }
    }
}