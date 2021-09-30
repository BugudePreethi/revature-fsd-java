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
	private char type;
	private int account_id;

	public int getAccount_id() {
		return account_id;
	}

	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}

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
	
	public char getType() {
		return type;
	}

	public void setType(char type) {
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
		// Choose whether withdraw or deposit
		System.out.print("Enter 'W' for withdrawl and 'D' for Deposit : ");
		type = scanner.nextLine().charAt(0);
		// Choose account
	    System.out.println("Choose an account_id from the given list of accounts.");
		System.out.print("Enter the account_id : ");
		int id = scanner.nextInt();
		account.setId(id);
		transaction.setAccount_id(id);
		transaction.setType(type);
		// Enter the amount
		System.out.print("Enter the amount : ");
		double amount = scanner.nextDouble();
		transaction.setAmount(amount);
	}
	Account account = new Account();
	@Override
	public void action() {
		// Get balance
		AccountDao bDao = new AccountDaoImpl();
		try {
			balance = bDao.showBalance(transaction.getAccount_id());
			transaction.setBalance(balance);
		} catch (SQLException e) {
			System.out.println("Failed getting balance");
		}
		
		amount = transaction.getAmount();
		balance = transaction.getBalance();
		if (type == 'D') {
			balance = balance + amount;
			System.out.print("The total balance is ");
			System.out.println(balance);
		}else if (type == 'W') {
			if (balance >= amount) {
				balance = balance - amount;
				System.out.print("The total balance is ");
				System.out.println(balance);
			} else {
				System.out.println("Insufficient Amount");
			}
		}
		transaction.setBalance(balance);
		
		account.setBalance(balance);
		TransactionDao tDao = new TransactionDaoImpl();
		try {
			tDao.create(transaction);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Failed inserting transactions");
		}
		
		try { 
			tDao.update(account);
			System.out.println("Account updated successfully");
		 } catch(SQLException e) { 
			 e.printStackTrace();
		     System.out.println("Failed updating accounts");
		 }
		

		CustomerMainMenu menu = new CustomerMainMenu("CustomerMainMenu");
		menu.displayMenuAndCaptureSelection();
		success = true;
	}
}
