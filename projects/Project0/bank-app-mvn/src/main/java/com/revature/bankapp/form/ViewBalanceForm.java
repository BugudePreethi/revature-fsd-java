package com.revature.bankapp.form;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.revature.bankapp.dao.AccountDao;
import com.revature.bankapp.dao.impl.AccountDaoImpl;
import com.revature.bankapp.main.BankApp;
import com.revature.bankapp.menu.ViewAccountsMenu;
import com.revature.bankapp.model.Account;

public class ViewBalanceForm extends Form{
	private String accountNumber;
	
	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public ViewBalanceForm(String name) {
		super(name);
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
		System.out.print("Choose an account from the given list of accounts");
		System.out.print("Enter the account number : ");
		accountNumber = scanner.nextLine();
	}

	@Override
	public void action() {
		System.out.print("Balance : ");
		AccountDao dao = new AccountDaoImpl();
		try {
			System.out.println(dao.showBalance(accountNumber));
		} catch(SQLException e) {
			System.out.println("Failed getting balance");
		}
		ViewAccountsMenu menu = new ViewAccountsMenu("View Accounts Menu");
		menu.displayMenuAndCaptureSelection();
		success = true;
	}
	
}
