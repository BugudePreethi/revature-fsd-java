package com.revature.bankapp.dao;

import java.util.List;

import com.revature.bankapp.exception.AppException;
import com.revature.bankapp.model.Transaction;

public interface TransactionDao {
	//void create(Transaction transaction) throws SQLException;
	//void update(Account account) throws SQLException;
	List<Transaction> list() throws AppException;
}
