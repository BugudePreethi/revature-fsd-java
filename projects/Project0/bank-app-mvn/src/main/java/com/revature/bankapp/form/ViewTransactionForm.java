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
	
	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
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
		System.out.print("Choose an account from the given list of accounts");
		System.out.print("Enter the account number : ");
		accountNumber = scanner.nextDouble();
		System.out.println("Enter 'W' for withdrawl and 'D' for Deposit");
		String type = transaction.getType();
		type = scanner.next();
		TransactionDao dao = new TransactionDaoImpl();
		List<Transaction> transactionList = null;
		try {
			transactionList = dao.list();
		} catch(SQLException e) {
			System.out.println("Failed getting transactions");
		}
		transactionList.forEach(System.out::println);
		
	}

	@Override
	public void action() {
		Account account = new Account();
		Double balance = account.getBalance();
		if(type == "W") {
			//account.setId(BankApp.getCurrentCustomer().getId());
			System.out.println(balance);
			if (balance < 2000) {
				System.out.println("Withdrawing the amount is not possible");
			} else {
				balance = balance - transaction.getAmount();
				System.out.println("The total balance is " + balance);
			}
			account.setBalance(balance);
			CustomerMainMenu menu = new CustomerMainMenu("CustomerMainMenu");
			menu.displayMenuAndCaptureSelection();
			success = true;
		} else if (transaction.getType() == "D") {
			balance = balance + transaction.getAmount();
			account.setBalance(balance);
			CustomerMainMenu menu = new CustomerMainMenu("CustomerMainMenu");
			menu.displayMenuAndCaptureSelection();
			success = true;
		}
		success = true;
	}

}
