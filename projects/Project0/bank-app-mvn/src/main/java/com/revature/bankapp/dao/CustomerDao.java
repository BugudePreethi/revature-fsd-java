package com.revature.bankapp.dao;

import java.sql.SQLException;
//import java.util.List;

import com.revature.bankapp.model.Customer;

public interface CustomerDao {
	//List<Customer> list() throws SQLException;
	Customer get(int id) throws SQLException;
	void create(Customer customer) throws SQLException;
	void update(Customer customer) throws SQLException;
}
