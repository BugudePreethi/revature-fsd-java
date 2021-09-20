package com.revature.bankapp.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.bankapp.model.Transaction;

public interface TransactionDao {
	void update(Transaction transaction) throws SQLException;
	List<Transaction> list() throws SQLException;
}
