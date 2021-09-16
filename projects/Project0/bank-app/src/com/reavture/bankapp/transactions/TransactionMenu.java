package com.reavture.bankapp.transactions;

import java.util.Scanner;
import com.revature.bankapp.main.BankApp;

public class TransactionMenu {
	private String type;
	private double balance;
	private double accountNumber;
		
	public TransactionMenu(String type, double balance, double accountNumber) {
		super();
		this.type = type;
		this.balance = balance;
		this.accountNumber = accountNumber;
	}

	/*CreateAccountMenu createAccountMenu = new CreateAccountMenu();
	balance = createAccountMenu.getbalance();*/ 
	
	public void action() {
		Scanner scanner = BankApp.getScanner();
		type = scanner.next();
		System.out.println("Enter the type of transaction : " + type);
		if(type == "D") {
			DepositMenu depositMenu = new DepositMenu("Deposit");
			depositMenu.action();
			balance = balance + depositMenu.getAmount();
		}
		else if (type == "W") {
			DepositMenu depositMenu = new DepositMenu;
			depositMenu.action();
			balance = balance - withdrawlMenu.getAmount();
		} else {
			System.out.println("Please enter 'W' for withdrawl and 'D' for Deposit");
		}
		
	}
		public void printTransactionStatements() {
			
			System.out.print("Account statement of " + accountNumber);
			System.out.print("Balance: " + balance);
		}
	}
	

