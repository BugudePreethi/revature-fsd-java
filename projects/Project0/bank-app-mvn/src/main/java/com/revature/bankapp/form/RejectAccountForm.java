package com.revature.bankapp.form;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.revature.bankapp.dao.AccountDao;
import com.revature.bankapp.dao.EmployeeDao;
import com.revature.bankapp.dao.impl.AccountDaoImpl;
import com.revature.bankapp.dao.impl.EmployeeDaoImpl;
import com.revature.bankapp.main.BankApp;
import com.revature.bankapp.menu.EmployeeMainMenu;
import com.revature.bankapp.model.Account;

public class RejectAccountForm extends Form{
	private String accountNumber;
	public RejectAccountForm(String name) {
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
		EmployeeDao dao = new EmployeeDaoImpl();
		List<Account> accountList = null;
		try {
			accountList = dao.list();
		} catch(SQLException e) {
			e.printStackTrace();
			System.out.println("Failed getting Accounts.");
		}
		System.out.print("Please select an account number : ");
		accountNumber = scanner.nextLine();
	}

	@Override
	public void action() {
		AccountDao dao = new AccountDaoImpl();
		try {
			dao.rejectAccount(accountNumber);
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("Failed to reject account");
		}
		EmployeeMainMenu menu = new EmployeeMainMenu("Menu");
		menu.displayMenuAndCaptureSelection();
		success = true;
		
	}
}
