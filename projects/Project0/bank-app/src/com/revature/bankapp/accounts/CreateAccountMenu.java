package com.revature.bankapp.accounts;

import com.revature.bankapp.menu.CustomerMainMenu;

public class CreateAccountMenu {
	private Long accountNumber;
	private double balance = 2000;
	
	public double getBalance() {
		return balance;
	}

	public CreateAccountMenu(Long accountNumber, double balance) {
		super();
		this.accountNumber = accountNumber;
		this.balance = balance;
	}
	
	public void action() {
		System.out.println("Account Number : " + accountNumber);
		System.out.println("Initial Balance : " + balance);
		CustomerMainMenu customerMainMenu = new CustomerMainMenu("Customer Menu");
		customerMainMenu.displayMenuAndCaptureSelection();
	}
	
}
