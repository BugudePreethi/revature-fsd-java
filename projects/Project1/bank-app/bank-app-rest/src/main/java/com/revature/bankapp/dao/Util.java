package com.revature.bankapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Util {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Util.class);
	
	public static Connection getConnection() throws SQLException{
		LOGGER.info("Util Start");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}		
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/bankapp","root","Gsem@416");
		
	}
}
