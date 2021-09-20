package com.revature.bankapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.bankapp.dao.AccountDao;
import com.revature.bankapp.dao.Util;
import com.revature.bankapp.form.ViewBalanceForm;
import com.revature.bankapp.form.ViewTransactionForm;
import com.revature.bankapp.main.BankApp;
import com.revature.bankapp.model.Account;

public class AccountDaoImpl implements AccountDao{

	//Creating a Account
	@Override
	public void create(Account account) throws SQLException {
		try(Connection connection = Util.getConnection()){
			String sql = "insert into account (accountNumber, balance, customer_id, approved) values (?, ?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setDouble(1, account.getAccountNumber());
			statement.setDouble(2, account.getBalance());
			statement.setInt(3, BankApp.getCurrentCustomer().getId());
			statement.setString(4, "N");
			statement.executeUpdate();
		}
	}

	//List of Accounts of a Customer
	@Override
	public List<Account> list() throws SQLException {
		List<Account> accountList = new ArrayList<>(); 
		try(Connection connection = Util.getConnection()){
			String sql = "SELECT * FROM account where customer_id = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, BankApp.getCurrentCustomer().getId());
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				Account account = new Account();
				account.setId(resultSet.getInt("id"));
				account.setAccountNumber(resultSet.getDouble("accountNumber"));
				account.setBalance(resultSet.getDouble("balance"));
				accountList.add(account);
			}
		}
		return accountList;
	}

	//View balance of specific account
	@Override
	public double showBalance(double accountNumber) throws SQLException {
		try(Connection connection = Util.getConnection()){
			String sql = "SELECT balance FROM bankapp.account where accountNumber = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			ViewBalanceForm AN = new ViewBalanceForm("View Balance Form");
			statement.setDouble(1, AN.getAccountNumber());
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				resultSet.getDouble("balance");			
			}
		}
		return accountNumber;
	}

	//Updating accounts after transaction
	@Override
	public void update(Account account) throws SQLException {
			try(Connection connection = Util.getConnection()){
				String sql = "update account set balance = ? where accountNumber = ?";
				PreparedStatement statement = connection.prepareStatement(sql);
				ViewTransactionForm viewTransactionForm = new ViewTransactionForm("Form");
				if(viewTransactionForm.getType() == "W") {
					//WithdrawlForm withdrawlForm = new WithdrawlForm("Form");
					statement.setDouble(1, viewTransactionForm.getBalance());
					statement.setDouble(2, viewTransactionForm.getAccountNumber());
					statement.executeUpdate(sql);
				} else {
					//DepositForm depositForm = new DepositForm("Form");
					statement.setDouble(1, viewTransactionForm.getBalance());
					statement.setDouble(2, viewTransactionForm.getAccountNumber());
					statement.executeUpdate(sql);
				}
			}
	}
	@Override
	public List<Account> Approvedlist() throws SQLException {
		List<Account> accountList1 = new ArrayList<>(); 
		try(Connection connection = Util.getConnection()){
			String sql = "SELECT * FROM account where approved = N";
			PreparedStatement statement = connection.prepareStatement(sql);
			ViewTransactionForm viewTransactionForm = new ViewTransactionForm("Form");
			statement.setString(1, viewTransactionForm.getType());
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				Account account = new Account();
				account.setId(resultSet.getInt("id"));
				account.setAccountNumber(resultSet.getDouble("accountNumber"));
				account.setBalance(resultSet.getDouble("balance"));
				accountList1.add(account);
			}
		}
		return accountList1;
	}
	
	
	
	
}
