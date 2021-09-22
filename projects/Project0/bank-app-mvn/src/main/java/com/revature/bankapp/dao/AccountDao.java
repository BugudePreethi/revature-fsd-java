package com.revature.bankapp.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.bankapp.model.Account;

public interface AccountDao {
	void create(Account account) throws SQLException;
	List<Account> list() throws SQLException;
	double showBalance (String accountNumber) throws SQLException;
	void update(Account account) throws SQLException;
	List<Account> Approvedlist() throws SQLException;
	String updateStatus (String accountNumber) throws SQLException;

}
