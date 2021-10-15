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
import com.revature.bankapp.model.Transaction;

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
			LOGGER.error("Error getting employee", e);
			throw new AppException(e);
		}
		return null;
	}

	@Override
	public List<Customer> list() throws AppException {
		List<Customer> customerList = new ArrayList<>();
		try(Connection connection = Util.getConnection()){
			String sql = "SELECT firstName, lastName, email, accountNumber,balance, approved FROM bankapp.customer c inner join account a where a.customer_id = c.id and approved = 'Y'";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				Customer customer = new Customer();
				customer.setFirstName(resultSet.getString("firstName"));
				customer.setLastName(resultSet.getString("lastName"));
				customer.setEmail(resultSet.getString("email"));
				Account account = new Account();
				account.setAccountNumber(resultSet.getString("accountNumber"));
				account.setBalance(resultSet.getDouble("balance"));
				account.setApproved(resultSet.getString("approved"));
				customer.setAccount(account);
				customerList.add(customer);
			}
		} catch(SQLException e) {
			LOGGER.error("Error getting list of employees", e);
			throw new AppException(e);
		}
		return customerList;
	}

	@Override
	public List<Transaction> transactionList(String accountNumber) throws AppException {
		List<Transaction> transactionList = new ArrayList<>();
		try(Connection connection = Util.getConnection()){
			String sql ="SELECT a.accountNumber, t.amount, t.type, t.balance FROM bankapp.transaction t inner join account a inner join customer c on a.customer_id = c.id and t.account_id = a.id where a.accountNumber = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, accountNumber);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				Transaction transaction = new Transaction();
				//transaction.setAccount_id(resultSet.getInt("a.id"));
				transaction.setAccountNumber(resultSet.getString("a.accountNumber"));
				transaction.setAmount(resultSet.getDouble("t.amount"));
				transaction.setType(resultSet.getString("t.type").charAt(0));
				transaction.setBalance(resultSet.getDouble("t.balance"));
				transactionList.add(transaction);
			}
		} catch(SQLException e) {
			LOGGER.error("Error getting transaction list", e);
			throw new AppException(e);
		}
		return transactionList;
	}
	
}
