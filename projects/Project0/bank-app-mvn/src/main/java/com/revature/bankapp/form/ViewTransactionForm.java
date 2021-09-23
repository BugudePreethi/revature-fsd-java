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

public class ViewTransactionForm extends Form {
	public String accountNumber;
	private double balance;
	
	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public ViewTransactionForm(String name) {
		super(name);
	}
	
	/*public ViewTransactionForm() {
	}*/
	Scanner scanner = BankApp.getScanner();
	Transaction transaction = new Transaction();
	@Override
	public void captureData() {
		AccountDao dao = new AccountDaoImpl();
		List<Account> accountList = null;
		try {
			accountList = dao.list();
		} catch (SQLException e) {
			System.out.println("Failed getting Customer.");
		}
		accountList.forEach(System.out::println);
		System.out.println("Choose an account from the given list of accounts.");
		System.out.print("Enter the account number : ");
		String accountNumber = scanner.next();
		transaction.setAccountNumber(accountNumber);
		System.out.println("Enter 'W' for withdrawl and 'D' for Deposit");
		String type = scanner.next();
		transaction.setType(type);
		TransactionDao dao1 = new TransactionDaoImpl();
		List<Transaction> transactionList = null;
		try {
			transactionList = dao1.list();
		} catch(SQLException e) {
			System.out.println("Failed getting transactions");
		}
		transactionList.forEach(System.out::println);
		
	}

	@Override
	public void action() {
		Account account = new Account();
		balance = getBalance();
		System.out.print("Balance : ");
		AccountDao dao = new AccountDaoImpl();
		try {
			System.out.println(dao.showBalance(accountNumber));
		} catch(SQLException e) {
			System.out.println("Failed getting balance");
		}
		if(transaction.getType() == "W") {
			if(balance >= transaction.getAmount()) {
				balance = balance - transaction.getAmount();
				System.out.println("The total balance is " + balance);
			} else {
				System.out.println("Insufficient Amount");
			}
			account.setBalance(balance);
		} else if (transaction.getType() == "D") {
			balance = balance + transaction.getAmount();
			account.setBalance(balance);
		}
		TransactionDao tDao = new TransactionDaoImpl();
		try {
			tDao.create(transaction);
			tDao.update(transaction);
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("Failed getting transactions");
		}
		CustomerMainMenu menu = new CustomerMainMenu("CustomerMainMenu");
		menu.displayMenuAndCaptureSelection();
		success = true;
	}

}
