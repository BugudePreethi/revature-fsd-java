package com.revature.bankapp.form;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.revature.bankapp.dao.AccountDao;
import com.revature.bankapp.dao.TransactionDao;
import com.revature.bankapp.dao.impl.AccountDaoImpl;
import com.revature.bankapp.dao.impl.TransactionDaoImpl;
import com.revature.bankapp.main.BankApp;
import com.revature.bankapp.menu.CustomerMainMenu;
import com.revature.bankapp.model.Account;
import com.revature.bankapp.model.Transaction;

public class WithdrawDepositForm extends Form {
	private double amount;
	private double balance;
	private String type;
	
	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public WithdrawDepositForm(String name) {
		super(name);
	}

	Transaction transaction = new Transaction();

	@Override
	public void captureData() {
		// Displays list of accounts
		AccountDao dao = new AccountDaoImpl();
		List<Account> accountList = null;
		try {
			accountList = dao.list();
		} catch (SQLException e) {
			System.out.println("Failed getting Customer.");
		}
		accountList.forEach(System.out::println);
		Scanner scanner = BankApp.getScanner();
		// Choose account
		System.out.println("Choose an account_id from the given list of accounts.");
		System.out.print("Enter the account_id : ");
		int id = scanner.nextInt();
		transaction.setAccount_id(id);
		// Choose whether withdraw or deposit
		System.out.println("Enter 'W' for withdrawl and 'D' for Deposit");
		String type = scanner.next();
		transaction.setType(type);
		// Enter the amount
		System.out.print("Enter the amount : ");
		double amount = scanner.nextDouble();
		transaction.setAmount(amount);
	}

	@Override
	public void action() {
		// Get balance
		System.out.print("Balance : ");
		AccountDao bDao = new AccountDaoImpl();
		try {
			balance = bDao.showBalance(transaction.getAccount_id());
			System.out.println(balance);
		} catch (SQLException e) {
			System.out.println("Failed getting balance");
		}
		type = transaction.getType();
		amount = transaction.getAmount();
		if (type == "D") {
			balance = balance + amount;
			System.out.print("The total balance is ");
			System.out.print(balance);
			transaction.setBalance(balance);
		}else if (type == "W") {
			if (balance >= amount) {
				balance = balance - amount;
				System.out.print("The total balance is ");
				System.out.print(balance);
				transaction.setBalance(balance);
			} else {
				System.out.println("Insufficient Amount");
			}
		}
		balance = transaction.getBalance();
		System.out.println(balance);
		TransactionDao tDao = new TransactionDaoImpl();
		try {
			tDao.create(transaction);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Failed inserting transactions");
		}
		/*
		 * AccountDao aDao = new AccountDaoImpl(); 
		 * try { aDao.update(account); 
		 * } catch
		 * (SQLException e) { e.printStackTrace();
		 * System.out.println("Failed updating accounts"); }
		 */

		CustomerMainMenu menu = new CustomerMainMenu("CustomerMainMenu");
		menu.displayMenuAndCaptureSelection();
		success = true;
	}
}
