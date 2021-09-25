package com.revature.bankapp.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.bankapp.model.Account;
import com.revature.bankapp.model.Transaction;

public interface TransactionDao {
	void create(Transaction transaction) throws SQLException;
	void update(Account account) throws SQLException;
	List<Transaction> list() throws SQLException;
	void insertTransfer(Transaction transaction) throws SQLException;
}
