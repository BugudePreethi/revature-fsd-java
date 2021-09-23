package com.revature.bankapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.bankapp.dao.TransactionDao;
import com.revature.bankapp.dao.Util;
import com.revature.bankapp.form.ViewTransactionForm;
import com.revature.bankapp.model.Transaction;

public class TransactionDaoImpl implements TransactionDao {
	
	// Withdraw and Deposit Form
	@Override
	public void create(Transaction transaction) throws SQLException {
		try(Connection connection = Util.getConnection()){
			String sql = "insert into transaction (account_id, amount, type, balance) values(?, ?, ?, ?);";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, transaction.getAccount_id());
			statement.setDouble(2, transaction.getAmount());
			statement.setString(3, transaction.getType());
			statement.setDouble(4, transaction.getBalance());
			statement.executeUpdate(sql);
		}
	}
	@Override
	public void update(Transaction transaction) throws SQLException {
		try (Connection connection = Util.getConnection()) {
			String sql = "update account set balance = ?, amount = ? where accountNumber = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setDouble(1, transaction.getBalance());
			statement.setDouble(2, transaction.getAmount());
			statement.setString(3, transaction.getAccountNumber());
			statement.executeUpdate(sql);
		}

	}
	// View Transaction Table of specific Amount

	@Override
	public List<Transaction> list() throws SQLException {
		List<Transaction> transactionList = new ArrayList<>(); 
		try(Connection connection = Util.getConnection()){
			String sql = "SELECT * FROM transaction";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				Transaction transaction = new Transaction();
				transaction.setAmount(resultSet.getDouble("amount"));
				transaction.setType(resultSet.getString("type"));
				transaction.setBalance(resultSet.getDouble("balance"));
				transactionList.add(transaction);
			}
		}
		return transactionList;
	}
	
	/*public void insertTransfer(Transactions transaction) throws SQLException {
		try (Connection connection = Util.getConnection()) {
			String sql = "insert into transaction (type, amount, account_id) values (?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, String.valueOf(transaction.getType()));
			statement.setDouble(2, transaction.getAmount());
			statement.setInt(3, transferAccountId);
			statement.executeUpdate();
		}
	}*/

}
