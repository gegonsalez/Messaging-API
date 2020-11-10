package com.flavanoids.API.Repository;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "ggonsalez";
    private static final String PASS = "";

    public static Connection createConnection() {
        Connection conn = null;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(URL,
                            USER, PASS);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
        }
        System.out.println("Opened database successfully...");
        return conn;
    }
}
