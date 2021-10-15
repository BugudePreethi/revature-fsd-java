package com.revature.bankapp.dao;

import java.util.List;

import com.revature.bankapp.exception.AppException;
import com.revature.bankapp.model.Transaction;

public interface TransactionDao {
	void create(Transaction transaction) throws AppException;
	void update(Account account) throws AppException;
	List<Transaction> list(int id) throws AppException;
}
