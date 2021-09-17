package com.revature.bankapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.bankapp.dao.AccountDao;
import com.revature.bankapp.dao.Util;
import com.revature.bankapp.model.Account;

public class AccountDaoImpl implements AccountDao{

	@Override
	public void create(Account account) throws SQLException {
		try(Connection connection = Util.getConnection()){
			String sql = "insert into account (account_number, balance, customer_id) values (?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setDouble(1, 100001);
			statement.setDouble(2, 2000);
			/*Customer customer;
			BankApp.setCurrentCustomer(customer);
			customer = BankApp.getCurrentCustomer();*/
			int id = 3;
			statement.setInt(3, id);
			statement.executeUpdate();
		}
	}

	@Override
	public Account getAccountsOfCustomer(int id) throws SQLException {
		try(Connection connection = Util.getConnection()){
			String sql = "SELECT * FROM account where customer_id = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			if(resultSet.next()) {
				Account account = new Account();
				account.setId(resultSet.getInt("id"));
				account.setAccountNumber(resultSet.getDouble("account_number"));
				account.setBalance(resultSet.getDouble("balance"));
				return account;
			}
		}
		return null;
	}
	
}
