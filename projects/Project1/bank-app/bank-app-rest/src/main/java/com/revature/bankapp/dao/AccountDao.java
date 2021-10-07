package com.revature.bankapp.dao;

import java.util.List;

import com.revature.bankapp.exception.AppException;
import com.revature.bankapp.model.Account;

public interface AccountDao {
	//Create a new account 
	void create(Account account) throws AppException;
	//View Accounts of current customer
	List<Account> list() throws AppException;
//	double showBalance (int account_id) throws SQLException;//View balance of a specific account
//	//void update(Account account) throws SQLException;
//	void approveAccount(String accountNumber) throws SQLException;//Approve Account
//	void rejectAccount(String accountNumber) throws SQLException;//Reject Account
}
