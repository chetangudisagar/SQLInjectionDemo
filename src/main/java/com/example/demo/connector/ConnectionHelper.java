package com.example.demo.connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static java.sql.DriverManager.getConnection;

public class ConnectionHelper {
    private static String url = "jdbc:mysql://localhost:3306/demo";
    private static String user = "root";
    private static String password = "";

    public static Connection getDefaultConnection() throws SQLException {
        return getConnection(url, user, password);
    }
}
