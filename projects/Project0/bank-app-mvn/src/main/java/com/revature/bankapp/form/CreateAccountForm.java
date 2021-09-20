package com.revature.bankapp.form;

import java.sql.SQLException;
import java.util.Scanner;

import com.revature.bankapp.dao.AccountDao;
import com.revature.bankapp.dao.impl.AccountDaoImpl;
import com.revature.bankapp.main.BankApp;
import com.revature.bankapp.menu.CustomerMainMenu;
import com.revature.bankapp.model.Account;

public class CreateAccountForm extends Form{
	private double accountNumber;
	private double balance;
	private char approved;
	
	public CreateAccountForm(String name) {
		super(name);
	}
	
	public double getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(double accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public char getApproved() {
		return approved;
	}

	public void setApproved(char approved) {
		this.approved = approved;
	}

	@Override
	public void captureData() {
		Scanner scanner = BankApp.getScanner();
		System.out.print("Account Number : ");
		accountNumber = scanner.nextDouble();
		System.out.println("The minimum amount in account should not be less than 2000.");
		System.out.print("Balance : ");
		balance = scanner.nextDouble();
		
	}
	@Override
	public void action() {
		AccountDao dao = new AccountDaoImpl();
		try {
			dao.create(new Account(accountNumber, balance));
			System.out.println("Account is created successfully");
		} catch (SQLException e) {
			System.out.println("Error in creating Account of a Customer");
		}
		CustomerMainMenu menu = new CustomerMainMenu("CustomerMainMenu");
		menu.displayMenuAndCaptureSelection();
	}
}
