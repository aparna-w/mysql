package com.java.test.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlClient {
	
	private static final String DB_USERNAME = "root";
	private static final String DB_PASSWORD = "password";
	private static final String DB_URL = "jdbc:mysql://localhost/?verifyServerCertificate=false&useSSL=true";
	
	public static Connection getInstance() {
		return getInstance(DB_USERNAME, DB_PASSWORD);
	}
	
	public static Connection getInstance(String userName, String password) {
		try {
			return DriverManager.getConnection(DB_URL, userName, password);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
