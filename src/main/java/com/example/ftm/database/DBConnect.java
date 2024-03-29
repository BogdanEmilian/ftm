package com.example.ftm.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {

    private static Connection connection;

    public static Connection connect() {
        if (connection == null) {
            try {
                //URL to the database
                connection =
                        DriverManager.getConnection("jdbc:mysql://localhost:3306/ftmdb?" +
                                "user=root&password=root");
            } catch (SQLException ex) {
                //Detailed error output
                System.out.println("SQLException: " + ex.getMessage());
                System.out.println("SQLState: " + ex.getSQLState());
                System.out.println("VendorError: " + ex.getErrorCode());
            }
        }

        return connection;
    }
}