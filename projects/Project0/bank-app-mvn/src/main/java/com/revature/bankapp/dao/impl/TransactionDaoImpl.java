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
			ViewTransactionForm viewTransactionForm = new ViewTransactionForm("Form");
			if (viewTransactionForm.getType() == "W") {
				statement.setDouble(1, viewTransactionForm.getBalance());
				statement.setDouble(2, viewTransactionForm.getAmount());
				statement.setDate(3, viewTransactionform.getDate());
				statement.setDouble(4, viewTransactionForm.getAccountNumber());
				statement.executeUpdate(sql);
			} else {
				String sql1 = "update transaction set balance = ?, amount = ?, date ? where accountNumber = ?";
				PreparedStatement statement1 = connection.prepareStatement(sql1);
				statement1.setDouble(1, viewTransactionForm.getBalance());
				statement1.setDouble(2, viewTransactionForm.getAmount());
				statement1.setDate(3, viewTransactionform.getDate());
				statement1.setDouble(4, viewTransactionForm.getAccountNumber());
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
				transaction.setDate(resultSet.getDate("date"));
				transaction.setAmount(resultSet.getDouble("amount"));
				transaction.setType(resultSet.getString("type"));
				transaction.setBalance(resultSet.getDouble("balance"));
				transactionList.add(transaction);
			}
		}
		return transactionList;
	}

}
