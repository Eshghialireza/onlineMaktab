package com.onlineMaktab.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {
    private Connection connection;
    private String serverName;
    private String serverPass;
    private String serverUrl;

    public DatabaseUtil() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        this.serverUrl = "jdbc:mysql://localhost:3306/maktabshop";
        this.serverName="root";
        this.serverPass="rootpass";
        this.connection = DriverManager.getConnection(serverUrl,serverName,serverPass);
    }
    public Connection getConnection() {
        return connection;
    }
}
