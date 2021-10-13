package com.revature.bankapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.bankapp.dao.CustomerDao;
import com.revature.bankapp.dao.Util;
import com.revature.bankapp.exception.AppException;
import com.revature.bankapp.model.Customer;

public class CustomerDaoImpl implements CustomerDao{
	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerDaoImpl.class);

	@Override 
	public void create(Customer customer) throws AppException {
    	LOGGER.info("Signup Start");
    	LOGGER.debug("{}",customer);
		try(Connection connection = Util.getConnection()) {
			String sql = "insert into customer (firstName, lastName, email, password) values (?, ?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, customer.getFirstName());
			statement.setString(2, customer.getLastName());
			statement.setString(3, customer.getEmail());
			statement.setString(4, customer.getPassword());
			statement.executeUpdate();	
			LOGGER.info("End");
		} catch(SQLException e) {
			LOGGER.error("Error inserting customer", e);
			throw new AppException(e);
		}
	}

	@Override
	public Customer getCustomerByEmail(String email) throws AppException {
		LOGGER.info("Login Start");
		LOGGER.debug("{}", email);
		Customer customer = null;
		try(Connection connection = Util.getConnection()) {
			String sql = "SELECT * FROM bankapp.customer where email = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, email);
			ResultSet resultSet = statement.executeQuery();	
			if (resultSet.next()) {
				customer = new Customer();
				customer.setId(resultSet.getInt("id"));
				customer.setFirstName(resultSet.getString("firstName"));
				customer.setLastName(resultSet.getString("lastName"));
				customer.setEmail(resultSet.getString("email"));
				customer.setPassword(resultSet.getString("password"));
			}
		} catch(SQLException e) {
			LOGGER.error("Error getting customer", e);
			throw new AppException(e);
		}
		return customer;
	}

}
