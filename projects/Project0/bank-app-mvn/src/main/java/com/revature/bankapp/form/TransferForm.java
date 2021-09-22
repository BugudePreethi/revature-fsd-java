package com.revature.bankapp.form;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.revature.bankapp.dao.AccountDao;
import com.revature.bankapp.dao.impl.AccountDaoImpl;
import com.revature.bankapp.main.BankApp;
import com.revature.bankapp.model.Account;

public class TransferForm extends Form{
	private String accountNumber;
	private String accountNumber1;
	private double amount;
	private double balance;
	private double balance1;

	public TransferForm(String name) {
		super(name);
	}

	public String getAccountNumber() {
		return accountNumber;
	}


	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}


	public String getAccountNumber1() {
		return accountNumber1;
	}


	public void setAccountNumber1(String accountNumber1) {
		this.accountNumber1 = accountNumber1;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getBalance1() {
		return balance1;
	}

	public void setBalance1(double balance1) {
		this.balance1 = balance1;
	}

	@Override
	public void captureData() {
		Scanner scanner = BankApp.getScanner();
		AccountDao dao = new AccountDaoImpl();
		List<Account> accountList = null;
		try {
			accountList = dao.list();
		} catch (SQLException e) {
			System.out.println("Failed getting Customer.");
		}
		accountList.forEach(System.out::println);
		System.out.print("Choose an accounts from the given list of accounts");
		System.out.println("Enter the account Number : ");
		accountNumber = scanner.nextLine();//Amount transfered from this account
		System.out.println("Enter the account in which amount needs to be transfered : ");
		accountNumber1 = scanner.nextLine();//Amount transfered to this account
		System.out.print("Enter the amount : ");
		amount = scanner.nextDouble();
		Account account = new Account();
		balance = account.getBalance();
		Account account1 = new Account();
		balance1 = account1.getBalance();
	}

	@Override
	public void action() {
		balance = balance - amount;
		balance1 = balance1 + amount;
		AccountDao dao = new AccountDaoImpl();
		try {
			Account account = new Account();
			dao.update(account);
			System.out.println("Account is updated Successfully");
		} catch(SQLException e) {
			System.out.println("Error in transfering the account");
		}
		
	}

}
