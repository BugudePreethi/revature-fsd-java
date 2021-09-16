package com.revature.bankapp.accounts;

import com.reavture.bankapp.transactions.TransactionMenu;

public class ViewAccountMenu {
	private Long accountNumber;
	private double balance;
	
	public ViewAccountMenu(Long accountNumber, double balance) {
		super();
		this.accountNumber = accountNumber;
		this.balance = balance;
	}
	
	public void action() {
		System.out.println("Account Number : " + accountNumber);
		System.out.println("Balance :" + balance);
		TransactionMenu transactionMenu = new TransactionMenu();
		transactionMenu.printTransactionStatement();
	}

}

