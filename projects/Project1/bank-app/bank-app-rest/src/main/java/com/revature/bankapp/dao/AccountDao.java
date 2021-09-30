package com.revature.bankapp.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.bankapp.model.Account;

public interface AccountDao {
	void create(Account account) throws SQLException;//Create a new account 
	List<Account> list() throws SQLException;//View Accounts of current customer
	double showBalance (int account_id) throws SQLException;//View balance of a specific account
	//void update(Account account) throws SQLException;
	void approveAccount(String accountNumber) throws SQLException;//Approve Account
	void rejectAccount(String accountNumber) throws SQLException;//Reject Account
}
