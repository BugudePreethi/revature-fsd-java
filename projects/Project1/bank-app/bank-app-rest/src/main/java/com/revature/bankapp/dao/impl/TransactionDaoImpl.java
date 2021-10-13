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
	public List<Transaction> list() throws AppException {
		LOGGER.info("Transaction List Start");
		List<Transaction> transactionList = new ArrayList<>(); 
		try(Connection connection = Util.getConnection()){
			String sql = "SELECT * FROM bankapp.transaction t inner join account a on t.account_id = a.id";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				Transaction transaction = new Transaction();
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
	
}
