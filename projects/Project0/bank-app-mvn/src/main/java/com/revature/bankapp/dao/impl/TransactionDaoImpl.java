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
	public void update(Transaction transaction) throws SQLException {
		try (Connection connection = Util.getConnection()) {
			String sql = "update transaction set balance = ?, amount = ?, date = ? where accountNumber = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			Transaction tType = new Transaction();
			if (tType.getType() == "W") {
				statement.setDouble(1, transaction.getBalance());
				statement.setDouble(2, transaction.getAmount());
				//statement.setDate(3, transaction.getDate());
				statement.setDouble(4, transaction.getAccountNumber());
				statement.executeUpdate(sql);
			} else {
				String sql1 = "update transaction set balance = ?, amount = ?, date ? where accountNumber = ?";
				PreparedStatement statement1 = connection.prepareStatement(sql1);
				statement1.setDouble(1, tType.getBalance());
				statement1.setDouble(2, tType.getAmount());
				//statement1.setDate(3, tType.getDate());
				statement1.setDouble(4, tType.getAccountNumber());
				statement1.executeUpdate(sql1);
			}
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
				//transaction.setDate(resultSet.getDate("date"));
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
