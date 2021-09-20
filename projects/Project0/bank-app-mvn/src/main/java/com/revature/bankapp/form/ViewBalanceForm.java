package com.revature.bankapp.form;

import java.util.Scanner;

import com.revature.bankapp.main.BankApp;
import com.revature.bankapp.menu.CustomerMainMenu;

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
		ViewAccountsForm viewAccountsForm = new ViewAccountsForm("List of Accounts");
		viewAccountsForm.action();
		System.out.print("Enter the account number : ");
		accountNumber = scanner.nextDouble();
		System.out.print(accountNumber);
	}

	@Override
	public void action() {
		/*AccountDao dao = new AccountDaoImpl();
		Account account = null;
		try {
			dao.get(balance);
		} catch(SQLException e) {
			System.out.println("Failed getting balance");
		}*/
		CustomerMainMenu menu = new CustomerMainMenu("CustomerMainMenu");
		menu.displayMenuAndCaptureSelection();
		success = true;
	}
	
}
