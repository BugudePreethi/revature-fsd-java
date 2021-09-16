package com.revature.bankapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.revature.bankapp.dao.CustomerDao;
import com.revature.bankapp.dao.Util;
import com.revature.bankapp.model.Customer;

public class CustomerDaoImpl implements CustomerDao{

	public Customer get(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public void create(Customer customer) throws SQLException {
		try(Connection connection = Util.getConnection()) {
			String sql = "insert into customer (firstName, lastName, email, password) values (?, ?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, "John");
			statement.setString(2, "Paul");
			statement.setString(3, "john");
			statement.setString(4, "123");
		}
	}

	public void update(Customer customer) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	

}
