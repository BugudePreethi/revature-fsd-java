package com.revature.bankapp.accounts;

import java.util.Scanner;
import com.revature.bankapp.main.BankApp;
import com.revature.bankapp.accounts.Account;

public class CreateAccount extends Account{
	private Long accountNumber;
	private Long balance;

	public CreateAccount(Long accountNumber, Long balance) {
		super(accountNumber);
		this.accountNumber = accountNumber;
		this.balance = balance;
	}

	public Long getAccountNumber() {
		return accountNumber;
	}	

	public Long getBalance() {
		return balance;
	}

	public void setBalance(Long balance) {
		this.balance = balance;
	}	

	public void dataToBeDisplayed() {
		Scanner scanner = BankApp.getScanner();	

		Account account = new Account(accountNumber);
		
		System.out.print("Account Number: ");
		accountNumber = account.getAccountNumber();
		
		System.out.print("Balance");
		balance = scanner.nextLong();
	
	}
	
}

