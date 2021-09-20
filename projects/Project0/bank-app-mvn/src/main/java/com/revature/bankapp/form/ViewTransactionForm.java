package com.revature.bankapp.form;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.revature.bankapp.dao.AccountDao;
import com.revature.bankapp.dao.impl.AccountDaoImpl;
import com.revature.bankapp.main.BankApp;
import com.revature.bankapp.menu.CustomerMainMenu;
import com.revature.bankapp.model.Account;

public class ViewTransactionForm extends Form {

	private int account_id;
	private String type;
	private double amount;
	private double balance;
	private double accountNumber;
	
	public int getAccount_id() {
		return account_id;
	}

	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public ViewTransactionForm(String name) {
		super(name);
	}
	
	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(double accountNumber) {
		this.accountNumber = accountNumber;
	}

	/*public ViewTransactionForm() {
	}*/
	Scanner scanner = BankApp.getScanner();
	@Override
	public void captureData() {
		System.out.println("Enter 'W' for withdrawl and 'D' for Deposit");
		type = scanner.next();
		AccountDao dao = new AccountDaoImpl();
		List<Account> accountList = null;
		try {
			accountList = dao.list();
		} catch (SQLException e) {
			System.out.println("Failed getting Customer.");
		}
		accountList.forEach(System.out::println);
		System.out.print("Choose an account from the given list of accounts : ");
		accountNumber = scanner.nextDouble();
		System.out.print("Enter the amount : ");
		amount = scanner.nextDouble();
	}

	@Override
	public void action() {
		if(type == "W") {
			Account account = new Account();
			//account.setId(BankApp.getCurrentCustomer().getId());
			balance = account.getBalance();
			System.out.println(balance);
			if (balance < 2000) {
				System.out.println("Withdrawing the amount is not possible");
			} else {
				balance = balance - amount;
				System.out.println("The total balance is " + balance);
			}
			account.setBalance(balance);
			CustomerMainMenu menu = new CustomerMainMenu("CustomerMainMenu");
			menu.displayMenuAndCaptureSelection();
			success = true;
		} else if (type == "D") {
			Account account = new Account();
			balance = account.getBalance();
			balance = balance + amount;
			account.setBalance(balance);
			CustomerMainMenu menu = new CustomerMainMenu("CustomerMainMenu");
			menu.displayMenuAndCaptureSelection();
			success = true;
		}
		success = true;
	}

}
