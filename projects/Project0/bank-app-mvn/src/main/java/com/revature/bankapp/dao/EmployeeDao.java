package com.revature.bankapp.dao;

import java.sql.SQLException;

import com.revature.bankapp.model.Employee;

public interface EmployeeDao {
	void create(Employee employee) throws SQLException;	
	Employee getEmployeeByEmail(String email) throws SQLException;
}
