package com.revature.bankapp.dao;

import java.sql.SQLException;

import com.revature.bankapp.model.Account;

public interface AccountDao {
	void create(Account account) throws SQLException;
	Account getAccountsOfCustomer(int id) throws SQLException;
}
