package com.parkingLot.db;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class HsqlDatabase {
    public Connection conn;


    public HsqlDatabase() {
        loadJdbcDriverForHsqlDb();
        setupConnection();

    }

    private void setupConnection() {
        try {
            conn = DriverManager.getConnection("jdbc:hsqldb:file:C:/Users/fornic01/Desktop/monday/src/main/resources/PARKING/", "sa", "");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void loadJdbcDriverForHsqlDb() {
        try {
            Class.forName("org.hsqldb.jdbcDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void shutdownHsqlDatabase() {
        Statement st = null;
        try {
            st = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            st.execute("SHUTDOWN");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() throws SQLException {
        shutdownHsqlDatabase();
        conn.close();
    }


}
