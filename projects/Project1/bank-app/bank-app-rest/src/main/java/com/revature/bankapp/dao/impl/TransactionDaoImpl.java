package com.revature.bankapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.bankapp.dao.TransactionDao;
import com.revature.bankapp.dao.Util;
import com.revature.bankapp.exception.AppException;
import com.revature.bankapp.model.Transaction;

public class TransactionDaoImpl implements TransactionDao {
	private static final Logger LOGGER = LoggerFactory.getLogger(TransactionDaoImpl.class);

	//View transactions
	@Override
	public List<Transaction> list(int id) throws AppException {
		LOGGER.info("Transaction List Start");
		Transaction transaction = new Transaction();
		List<Transaction> transactionList = new ArrayList<>(); 
		try(Connection connection = Util.getConnection()){
			String sql = "SELECT * FROM bankapp.transaction t inner join account a on t.account_id = a.id where a.id = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				transaction.setAccount_id(resultSet.getInt("account_id"));
				transaction.setAmount(resultSet.getDouble("amount"));
				transaction.setType(resultSet.getString("type").charAt(0));
				transaction.setBalance(resultSet.getDouble("balance"));
				transaction.setAccountNumber(resultSet.getString("a.accountNumber"));
				transactionList.add(transaction);
			}
		}catch(SQLException e) {
			LOGGER.error("Error getting transaction list", e);
			throw new AppException(e);
		}
		return transactionList;
	}
	
	@Override
	public double currentBalance(int accountId) throws AppException {
		double currentBalance = 0;
		try (Connection connection = Util.getConnection()){
			String sql = "select balance from account where id = ?";
			PreparedStatement s = connection.prepareStatement(sql);
			s.setInt(1, (int)accountId); 
			ResultSet r = s.executeQuery();
			if(r.next()) {
				currentBalance = r.getDouble("balance");
			}
		} catch(SQLException e) {
			throw new AppException(e);
		}
		return currentBalance;
	}

	//Withdraw or deposit Form
	@Override
	public void create(int account_id, char type, double amount, double balance) throws AppException {
		LOGGER.info("Deposit or withdraw Start");
		try(Connection connection = Util.getConnection()) {
			String sql = "insert into transaction (account_id, amount, type, balance) values (?, ?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, account_id);
			statement.setDouble(2, amount);
			statement.setString(3, String.valueOf(type));
			statement.setDouble(4, balance);
			statement.executeUpdate();
			LOGGER.info("End");
		} catch(SQLException e) {
			LOGGER.error("Error in inserting deposit or withdraw into transaction table");
			throw new AppException(e);
		} 
	} 

	//Update account after deposit
	@Override
	public void updateDeposit(int account_id, double balance) throws AppException {
		LOGGER.info("Update account Start");
		try (Connection connection = Util.getConnection()) {
			String sql = "update account set balance = ? where id = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setDouble(1, balance);
			statement.setInt(2, account_id);
			statement.executeUpdate();
		} catch(SQLException e) {
			LOGGER.error("Error updating account", e);
			throw new AppException(e);
		}
	}
	
}
