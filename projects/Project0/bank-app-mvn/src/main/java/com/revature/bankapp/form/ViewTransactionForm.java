package com.revature.bankapp.form;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.revature.bankapp.dao.AccountDao;
import com.revature.bankapp.dao.TransactionDao;
import com.revature.bankapp.dao.impl.AccountDaoImpl;
import com.revature.bankapp.dao.impl.TransactionDaoImpl;
import com.revature.bankapp.main.BankApp;
import com.revature.bankapp.menu.ViewAccountsMenu;
import com.revature.bankapp.model.Account;
import com.revature.bankapp.model.Transaction;

public class ViewTransactionForm extends Form{
	private int account_id;

	public ViewTransactionForm(String name) {
		super(name);
	}

	@Override
	public void captureData() {
		Scanner scanner = BankApp.getScanner();
		Transaction transaction = new Transaction();
		AccountDao dao = new AccountDaoImpl();
		List<Account> accountList = null;
		try {
			accountList = dao.list();
		} catch (SQLException e) {
			System.out.println("Failed getting Customer.");
		}
		accountList.forEach(System.out::println);
		System.out.print("Select an account_id to view transactions of the account : ");
		account_id = scanner.nextInt();
		transaction.setAccount_id(account_id);
		System.out.println(transaction.getAccount_id());
	}

	@Override
	public void action() {
		TransactionDao dao = new TransactionDaoImpl();
		List<Transaction> transactionList = null;
		try {
			transactionList = dao.list();
		} catch (SQLException e) {
			System.out.println("Failed getting transaction");
		}
		transactionList.forEach(System.out::println);
		ViewAccountsMenu menu = new ViewAccountsMenu("View Accounts Menu");
		menu.displayMenuAndCaptureSelection();
		success = true;
	}

}
