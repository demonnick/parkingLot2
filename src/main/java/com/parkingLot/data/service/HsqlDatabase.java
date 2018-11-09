package com.parkingLot.data.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class HsqlDatabase {
	public Connection conn;

	// Connecting to database =>
	// Executing Query
	public HsqlDatabase() {
		try {
			loadJdbcDriverForHsqlDb();
			setupConnection();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private void setupConnection() throws SQLException {
		conn = DriverManager.getConnection("jdbc:hsqldb:file:C:/Users/fornic01/Desktop/parkingLot/src/main/webapp/WEB-INF\\parking/", "sa", "");
	}

	private void loadJdbcDriverForHsqlDb() throws ClassNotFoundException {
		Class.forName("org.hsqldb.jdbcDriver");
	}

	private void shutdownHsqlDatabase() throws SQLException {
		Statement st = conn.createStatement();
		st.execute("SHUTDOWN");
	}

	public void closeConnection() throws SQLException {
		shutdownHsqlDatabase();
		conn.close(); // if there are no other open connection
	}
}
