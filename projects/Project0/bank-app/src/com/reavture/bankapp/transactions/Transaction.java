package com.reavture.bankapp.transactions;

import com.revature.bankapp.main.BankApp;
import com.revature.bankapp.accounts.ViewAccounts;
import java.util.Scanner;

public class Transaction {
	private static char type;
	private static double amount;
	private double balance;
	private Transaction[] transactions;
	public Transaction(char type, double amount) {
		this.type = type;
		this.amount = amount;
		this.transactions = transactions;
	}
	
	public char getType() {
		return type;
	}
	public double getAmount() {
		return amount;
	}
	
	public void displayTransaction(double balance) {
		System.out.printf("%4c %12.2f %8.2f\n", type, amount, balance);
	}
	
	public void chooseType() {		
		Transaction transaction = new Transaction(type, amount);		
		Transaction[] transactionArray = {transaction};
		for(static Transaction transaction : transactions) {
			if(transaction.getType() == 'D') {
				balance = balance + transaction.getAmount();
			}
			if (transaction.getType() == 'W') {
				balance = balance - transaction.getAmount();
			}
			transaction.displayTransaction(balance);
		}
	}
	
	public void printTransactionStatements() {
		System.out.print("Account statement of " + account.getAccountNumber());
		System.out.print("Initial Balance: " + account.getBalance());
	}
	
}
