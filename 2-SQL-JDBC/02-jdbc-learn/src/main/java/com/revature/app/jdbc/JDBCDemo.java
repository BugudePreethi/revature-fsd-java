package com.revature.app.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo {

	public static void main(String[] args) {
		Connection connection = null;
		try {
			//Driver driver = new Driver();
			//Load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Establishes the connection between java file and mysql
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/learndb",
					"root",
					"Gsem@416");
			System.out.println(connection.getClass().getName());
			System.out.println("Connection Successful.");
			String sql = "insert into department (name) values ('Innovation')";
			Statement statement = connection.createStatement();
			statement.executeUpdate(sql); 
			//statement.executeQuery("Select statement");
			connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
