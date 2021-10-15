package com.revature.bankapp.dao;

import java.util.List;

import com.revature.bankapp.exception.AppException;
import com.revature.bankapp.model.Account;
import com.revature.bankapp.model.Transaction;

public interface TransactionDao {
	void create(int account_id, char type, double amount, double balance) throws AppException;
	List<Transaction> list(int id) throws AppException;
	double currentBalance(int accountId) throws AppException;
	//Update account after transaction
	void updateDeposit(int account_id, double balance) throws AppException;
}
