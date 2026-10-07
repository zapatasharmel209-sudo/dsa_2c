package com.mycompany.zapata_program;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MsAccessConnection {
    
    public static Connection connect() {
        try {
            // Register the UCanAccess driver
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            
            // Connection URL with your specific file path
            String url = "jdbc:ucanaccess://C://Users//CL2-PC//Downloads//Student_Managemen.accdb";
            
            // Establish and return the connection
            Connection conn = DriverManager.getConnection(url);
            return conn;
            
        } catch (ClassNotFoundException e) {
            System.out.println("UCanAccess driver not found in classpath!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("SQL Exception occurred while connecting to Access DB!");
            e.printStackTrace();
        }
        return null;
    }
}