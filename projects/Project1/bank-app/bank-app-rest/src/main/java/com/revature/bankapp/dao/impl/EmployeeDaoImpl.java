package com.revature.bankapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.bankapp.dao.EmployeeDao;
import com.revature.bankapp.dao.Util;
import com.revature.bankapp.exception.AppException;
import com.revature.bankapp.model.Account;
import com.revature.bankapp.model.Customer;
import com.revature.bankapp.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeDaoImpl.class);

	@Override
	public void create(Employee employee) throws AppException {
		LOGGER.info("Start");
		LOGGER.debug("{}",employee);
		try(Connection connection = Util.getConnection()) {
			String sql = "insert into employee (firstName, lastName, email, password) values (?, ?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, employee.getFirstName());
			statement.setString(2, employee.getLastName());
			statement.setString(3, employee.getEmail());
			statement.setString(4, employee.getPassword());
			statement.executeUpdate();	
			LOGGER.info("End");
		} catch(SQLException e) {
			LOGGER.error("Error inserting employee", e);
			throw new AppException(e);
		}
		
	}

	@Override
	public Employee getEmployeeByEmail(String email) throws AppException {
		LOGGER.info("Login Start");
		try(Connection connection = Util.getConnection()) {
			String sql = "SELECT * FROM bankapp.employee where email = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, email);
			ResultSet resultSet = statement.executeQuery();	
			while (resultSet.next()) {
				Employee employee = new Employee();
				employee.setFirstName(resultSet.getString("firstName"));
				employee.setLastName(resultSet.getString("lastName"));
				employee.setEmail(resultSet.getString("email"));
				employee.setPassword(resultSet.getString("password"));
				return employee;
			}
		} catch(SQLException e) {
			LOGGER.error("Error getting customer", e);
			throw new AppException(e);
		}
		return null;
	}

	@Override
	public List<Account> list() throws SQLException {
		List<Account> accountList = new ArrayList<>();
		try(Connection connection = Util.getConnection()){
			String sql = "select * from account where approved = 'N'";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				Account account = new Account();
				account.setId(resultSet.getInt("id"));
				account.setAccountNumber(resultSet.getString("accountNumber"));
				account.setCustomerId(resultSet.getInt("customer_id"));
				account.setBalance(resultSet.getDouble("balance"));
				accountList.add(account);
			}
			accountList.forEach(System.out::println);
		}
		return null;
	}

	@Override
	public List<Customer> customerList() throws SQLException {
		List<Customer> customerList = new ArrayList<>();
		List<Account> accountList = new ArrayList<>();
		try(Connection connection = Util.getConnection()){
			String sql ="select customer_id,firstName,lastName,email,accountNumber,balance,approve from customer c inner join account a where a.customer_id = c.id";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				Customer customer = new Customer();
				customer.setFirstName(resultSet.getString("firstName"));
				customer.setLastName(resultSet.getString("lastName"));
				customer.setEmail(resultSet.getString("email"));
				customerList.add(customer);
				Account account = new Account();
				account.setAccountNumber(resultSet.getString("accountNumber"));
				account.setBalance(resultSet.getDouble("balance"));
				account.setCustomerId(resultSet.getInt("customer_id"));
				account.setApproved(resultSet.getString("approved"));
				accountList.add(account);
			}
		}
		return null;
	}
	
}
