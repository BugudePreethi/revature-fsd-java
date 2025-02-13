package com.revature.bankapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.bankapp.dao.TransactionDao;
import com.revature.bankapp.dao.Util;
import com.revature.bankapp.form.WithdrawDepositForm;
import com.revature.bankapp.model.Account;
import com.revature.bankapp.model.Transaction;

public class TransactionDaoImpl implements TransactionDao {
	
	// Withdraw and Deposit Form
	@Override
	public void create(Transaction transaction) throws SQLException {
		try(Connection connection = Util.getConnection()){
			String sql = "insert into transaction (account_id, amount, type, balance) values (?, ?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			System.out.println(transaction);
			statement.setInt(1, transaction.getAccount_id());
			statement.setDouble(2, transaction.getAmount());
			statement.setString(3, String.valueOf(transaction.getType()));
			statement.setDouble(4, transaction.getBalance());
			statement.executeUpdate();
		}
	}
	//Update account after deposit and transaction
		@Override
		public void update(Account account) throws SQLException {
			try (Connection connection = Util.getConnection()) {
				String sql = "update account set balance = ? where id = ?";
				PreparedStatement statement = connection.prepareStatement(sql);
				statement.setDouble(1, account.getBalance());
				statement.setInt(2, account.getId());
				statement.executeUpdate();
			}

		}

	//View transactions
	@Override
	public List<Transaction> list() throws SQLException {
		List<Transaction> transactionList = new ArrayList<>(); 
		Transaction transaction = new Transaction();
		try(Connection connection = Util.getConnection()){
			String sql = "SELECT * FROM transaction/* where account_id = ?*/";
			PreparedStatement statement = connection.prepareStatement(sql);
//			statement.setInt(1, transaction.getAccount_id());
//			System.out.println(transaction.getAccount_id());
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				transaction.setAccount_id(resultSet.getInt("account_id"));
				transaction.setAmount(resultSet.getDouble("amount"));
				transaction.setType(resultSet.getString("type").charAt(0));
				transaction.setBalance(resultSet.getDouble("balance"));
				transactionList.add(transaction);
			}
		}
		return transactionList;
	}
	
	public void insertTransfer(Transaction transaction) throws SQLException {
		try (Connection connection = Util.getConnection()) {
		    connection.setAutoCommit(false);
			String sql = "insert into transaction (type, amount, account_id) values (?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, String.valueOf(transaction.getType()));
			statement.setDouble(2, transaction.getAmount());
			statement.setInt(3, 3);
			statement.executeUpdate();
			connection.commit();
		}
	}
	
}
