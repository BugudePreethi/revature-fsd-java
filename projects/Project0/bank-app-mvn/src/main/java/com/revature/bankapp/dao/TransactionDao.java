package com.revature.bankapp.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.bankapp.model.Account;
import com.revature.bankapp.model.Transaction;

public interface TransactionDao {
	void create(Transaction transaction) throws SQLException;
	List<Transaction> list() throws SQLException;
	void add(Transaction transaction) throws SQLException;
}
