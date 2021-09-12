package com.revature.bankapp.accounts;

import java.util.Scanner;
import com.revature.bankapp.main.BankApp;
//import com.revature.bankapp.transactions;

public class ViewAccounts extends Account {
	private Long accountNumber;
	private Long balance;
	//private Transaction[] transactions;
	
	public ViewAccounts(Long accountNumber, Long balance/*,
			Transaction[] transactions*/) {
		super(accountNumber);
		this.accountNumber = accountNumber;
		this.balance = balance;
		//this.transactions = transactions;
	}
	
	public void detailsOfCustomer() {
		Scanner scanner = BankApp.getScanner();
		
		Account account = new Account(accountNumber);
		System.out.print("Account Number: ");
		accountNumber = account.getAccountNumber();
		
		System.out.print("Balance: ");
		//balance = transactions.getBalance();
	}
	
}

