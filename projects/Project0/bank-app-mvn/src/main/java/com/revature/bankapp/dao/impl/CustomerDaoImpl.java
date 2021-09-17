package com.revature.bankapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.bankapp.dao.CustomerDao;
import com.revature.bankapp.dao.Util;
import com.revature.bankapp.model.Customer;

public class CustomerDaoImpl implements CustomerDao{

    @Override 
	public void create(Customer customer) throws SQLException {
		try(Connection connection = Util.getConnection()) {
			String sql = "insert into customer (firstName, lastName, email, password) values (?, ?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, "William");
			statement.setString(2, "Smith");
			statement.setString(3, "william@gmail.com");
			statement.setString(4, "smith");
			statement.executeUpdate();	
			
		}
	}

	@Override
	public Customer getCustomerByEmail(String email) throws SQLException {
		
		try(Connection connection = Util.getConnection()) {
			String sql = "SELECT * FROM bankapp.customer where email = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, email);
			ResultSet resultSet = statement.executeQuery();	
			if (resultSet.next()) {
				Customer customer = new Customer();
				customer.setId(resultSet.getInt("id"));
				customer.setFirstName(resultSet.getString("firstName"));
				customer.setLastName(resultSet.getString("lastName"));
				customer.setEmail(resultSet.getString("email"));
				customer.setPassword(resultSet.getString("password"));
				return customer;
			}
		}
		return null;
	}

}
