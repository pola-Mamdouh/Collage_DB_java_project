
package com.mycompany.javadb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String HOSTNAME = "localhost";
    private static final String DATABASE_NAME = "Collage"; // Database Name
    private static final String USERNAME = "sa";
    private static final String PASSWORD = "DBJAVA";

    public static Connection getConnection() throws SQLException {
        String url = "jdbc:sqlserver://" + HOSTNAME 
                + ";databaseName=" + DATABASE_NAME + ";encrypt=true;trustServerCertificate=true";
        return DriverManager.getConnection(url, USERNAME, PASSWORD);
    }
}