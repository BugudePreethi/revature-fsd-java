package com.revature.bankapp.form;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.revature.bankapp.dao.AccountDao;
import com.revature.bankapp.dao.impl.AccountDaoImpl;
import com.revature.bankapp.main.BankApp;
import com.revature.bankapp.menu.CustomerMainMenu;
import com.revature.bankapp.model.Account;

public class ViewBalanceForm extends Form{
	private double accountNumber;
	
	public double getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(double accountNumber) {
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
		accountNumber = scanner.nextDouble();
	}

	@Override
	public void action() {
		AccountDao dao = new AccountDaoImpl();
		Account account = null;
		try {
			dao.get(balance);
		} catch(SQLException e) {
			System.out.println("Failed getting balance");
		}
		CustomerMainMenu menu = new CustomerMainMenu("CustomerMainMenu");
		menu.displayMenuAndCaptureSelection();
		success = true;
	}
	
}
