package com.revature.bankapp.form;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.revature.bankapp.dao.AccountDao;
import com.revature.bankapp.dao.impl.AccountDaoImpl;
import com.revature.bankapp.main.BankApp;
import com.revature.bankapp.menu.ViewAccountsMenu;
import com.revature.bankapp.model.Account;

public class ApproveAccountForm extends Form{
	private String accountNumber;
	public ApproveAccountForm(String name) {
		super(name);
	}

	public String getAccountNumber() {
		return accountNumber;
	}


	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
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
		System.out.println("Please select an account number");
		accountNumber = scanner.nextLine();
		
	}

	@Override
	public void action() {
		AccountDao dao = new AccountDaoImpl();
		try {
			System.out.println(dao.updateStatus(accountNumber));
		}catch(SQLException e) {
			System.out.println("Unable to upload status");
		}
		ViewAccountsMenu menu = new ViewAccountsMenu("Menu");
		menu.displayMenuAndCaptureSelection();
		success = true;
	}

}
