package com.revature.bankapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.bankapp.dao.AccountDao;
import com.revature.bankapp.dao.Util;
import com.revature.bankapp.form.ApproveAccountForm;
import com.revature.bankapp.form.TransferForm;
import com.revature.bankapp.main.BankApp;
import com.revature.bankapp.model.Account;

public class AccountDaoImpl implements AccountDao{

	//Creating a Account
	@Override
	public void create(Account account) throws SQLException {
		try(Connection connection = Util.getConnection()){
			String sql = "insert into account (accountNumber, balance, customer_id, approved) values (?, ?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, account.getAccountNumber());
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
				account.setAccountNumber(resultSet.getString("accountNumber"));
				account.setBalance(resultSet.getDouble("balance"));
				accountList.add(account);
			}
		}
		return accountList;
	}

	//View balance of specific account
	@Override
	public double showBalance(String accountNumber) throws SQLException {
		double balanceInDB = 0;
		try(Connection connection = Util.getConnection()){
			String sql = "SELECT balance FROM bankapp.account where accountNumber = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, accountNumber);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				balanceInDB = (double) resultSet.getDouble("balance");			
			}
		}
		return balanceInDB;
	}

	
	@Override
	public List<Account> Approvedlist() throws SQLException {
		List<Account> accountList1 = new ArrayList<>(); 
		try(Connection connection = Util.getConnection()){
			String sql = "SELECT * FROM account where approved = N";
			PreparedStatement statement = connection.prepareStatement(sql);
			/*Transaction viewTransactionForm = new ViewTransactionForm("Form");
			statement.setString(1, viewTransactionForm.getType());
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				Account account = new Account();
				account.setId(resultSet.getInt("id"));
				account.setAccountNumber(resultSet.getString("accountNumber"));
				account.setBalance(resultSet.getDouble("balance"));
				accountList1.add(account);
			}*/
		}
		return accountList1;
	}

	//Transfer Amount from one account to another
	@Override
	public void update(Account account) throws SQLException {
		try (Connection connection = Util.getConnection()) {
			String sql = "update account set balance = ? where accountNumber = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			TransferForm transferForm = new TransferForm("Form");
			statement.setDouble(1, transferForm.getBalance());
			statement.setString(2, transferForm.getAccountNumber());
			statement.executeUpdate(sql);
			String sql1 = "update account set balance = ? where accountNumber = ?";
			PreparedStatement statement1 = connection.prepareStatement(sql1);
			TransferForm transferForm1 = new TransferForm("Form");
			statement1.setDouble(1, transferForm1.getBalance1());
			statement1.setString(2, transferForm1.getAccountNumber1());			
			statement.executeUpdate(sql1);
		}
	}

	@Override
	public String updateStatus(String accountNumber) throws SQLException {
		try(Connection connection = Util.getConnection()){
			String sql ="update account set approved = ? where accountNumber = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			ApproveAccountForm approve = new ApproveAccountForm("Form");
			statement.setString(1, "Y");
			statement.setString(2, approve.getAccountNumber());
		}
		return updateStatus(null);
	}
	
	
}
