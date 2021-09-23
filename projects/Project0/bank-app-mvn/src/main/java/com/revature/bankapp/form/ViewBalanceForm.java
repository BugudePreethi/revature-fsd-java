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
	private int account_id;
	
	public int getAccount_id() {
		return account_id;
	}

	public void setAccount_id(int account_id) {
		this.account_id = account_id;
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
		System.out.print("Choose an account_id from the given list of accounts");
		System.out.print("Enter the account id : ");
		account_id = scanner.nextInt();
	}

	@Override
	public void action() {
		System.out.print("Balance : ");
		AccountDao dao = new AccountDaoImpl();
		try {
			System.out.println(dao.showBalance(account_id));
		} catch(SQLException e) {
			System.out.println("Failed getting balance");
		}
		ViewAccountsMenu menu = new ViewAccountsMenu("View Accounts Menu");
		menu.displayMenuAndCaptureSelection();
		success = true;
	}
	
}
