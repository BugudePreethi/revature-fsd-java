package com.revature.bankapp.dao;

import java.sql.SQLException;

import com.revature.bankapp.model.Customer;

public interface CustomerDao {
	void create(Customer customer) throws SQLException;	
	Customer getCustomerByEmail(String email) throws SQLException;
		
}
