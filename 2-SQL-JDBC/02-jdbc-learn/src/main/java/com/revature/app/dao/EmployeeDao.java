package com.revature.app.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.app.model.Employee;

public interface EmployeeDao {
	List<Employee> list() throws SQLException;
	Employee get(int id) throws SQLException;
	void create(Employee employee) throws SQLException;
	void update(Employee employee) throws SQLException;
	void delete(int id) throws SQLException;
	
}
