package com.revature.bankapp.dao;

import java.util.List;

import com.revature.bankapp.exception.AppException;
import com.revature.bankapp.model.Account;

public interface AccountDao {
	//Create a new account 
	void create(Account account) throws AppException;
	//View Accounts of current customer
	List<Account> list(int id) throws AppException;
}
