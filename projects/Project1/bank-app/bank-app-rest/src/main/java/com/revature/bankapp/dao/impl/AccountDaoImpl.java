package com.revature.bankapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.bankapp.dao.AccountDao;
import com.revature.bankapp.dao.Util;
import com.revature.bankapp.exception.AppException;
import com.revature.bankapp.model.Account;
import com.revature.bankapp.model.Customer;

public class AccountDaoImpl implements AccountDao{
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerDaoImpl.class);

	//Creating a Account
	@Override
	public void create(Account account) throws AppException {
		LOGGER.info("Account Start");
		LOGGER.debug("{}",account);
		try(Connection connection = Util.getConnection()){
			String sql = "insert into account (accountNumber, balance, customer_id, approved) values (?, ?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, account.getAccountNumber());
			statement.setDouble(2, account.getBalance());
			statement.setInt(3, account.getCustomerId());
			statement.setString(4, "N");
			statement.executeUpdate();
			LOGGER.info("End");
		} catch(SQLException e) {
			LOGGER.error("Error creating account", e);
			throw new AppException(e);
		}
	}

//	//List of Accounts of a Customer
	@Override
	public List<Account> list() throws AppException {
		LOGGER.info("Create account Start"); 
		List<Account> accountList = new ArrayList<>();
		try(Connection connection = Util.getConnection()){
			String sql = "SELECT * FROM customer c inner join account a on a.customer_id = (c.id=1);";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				Customer customer = new Customer();
				customer.setId(resultSet.getInt("id"));
//				customer.setFirstName(resultSet.getString("firstName"));
//				customer.setLastName(resultSet.getString("lastName"));
//				customer.setEmail(resultSet.getString("email"));
//				customer.setPassword(resultSet.getString("password"));
				Account account = new Account();
				account.setId(resultSet.getInt("id"));
				account.setAccountNumber(resultSet.getString("accountNumber"));
				account.setBalance(resultSet.getDouble("balance"));
				account.setApproved(resultSet.getString("approved"));
				account.setCustomerId(customer.getId());
				accountList.add(account);
			}
		} catch(SQLException e) {
			LOGGER.error("Error getting account", e);
			throw new AppException(e);
		}
		return accountList;
	}
//
//	//View balance of specific account
//	@Override
//	public double showBalance(int account_id) throws SQLException {
//		double balanceInDB = 0;
//		try(Connection connection = Util.getConnection()){
//			String sql = "SELECT balance FROM bankapp.account where id = ?";
//			PreparedStatement statement = connection.prepareStatement(sql);
//			statement.setInt(1, account_id);
//			ResultSet resultSet = statement.executeQuery();
//			if (resultSet.next()) {
//				balanceInDB = (double) resultSet.getDouble("balance");			
//			}
//		}
//		return balanceInDB;
//	}
//	
//
//
////	//Transfer Amount from one account to another
////	@Override
////	public void update(Account account) throws SQLException {
////		try (Connection connection = Util.getConnection()) {
////			String sql = "update account set balance = ? where accountNumber = ?";
////			PreparedStatement statement = connection.prepareStatement(sql);
////			TransferForm transferForm = new TransferForm("Form");
////			statement.setDouble(1, transferForm.getBalance());
////			statement.setString(2, transferForm.getAccountNumber());
////			statement.executeUpdate(sql);
////			String sql1 = "update account set balance = ? where accountNumber = ?";
////			PreparedStatement statement1 = connection.prepareStatement(sql1);
////			TransferForm transferForm1 = new TransferForm("Form");
////			statement1.setDouble(1, transferForm1.getBalance1());
////			statement1.setString(2, transferForm1.getAccountNumber1());			
////			statement.executeUpdate(sql1);
////		}
////	}
////	
//	//Approve account 
//	@Override
//	public void approveAccount(String accountNumber) throws SQLException {
//		try(Connection connection = Util.getConnection()){
//			String sql ="update account set approved = 'Y' where accountNumber = ?";
//			PreparedStatement statement = connection.prepareStatement(sql);
//			statement.setString(1, accountNumber);
//			statement.executeUpdate();
//		}
//	}
//	
//	//Reject Account
//	@Override
//	public void rejectAccount(String accountNumber) throws SQLException {
//		try(Connection connection = Util.getConnection()){
//			String sql ="update account set approved = 'R' where accountNumber = ?";
//			PreparedStatement statement = connection.prepareStatement(sql);
//			statement.setString(1, accountNumber);
//			statement.executeUpdate();
//		}
//	}
	
	
	
}
