package com.revature.bankapp.model;

public class AccountClass {
	
	//Instance Variables
	private long id;
	private int accountNumber;
	private float balance;
	//private transactionList[] transactions;
	
	//Constructor
	public AccountClass(int accountNumber, float balance/*, transactionList[] transactions*/) {
		super();
		this.accountNumber = accountNumber;
		this.balance = balance;
		//this.transactions = transactions;
	}
	
	//Instance Method

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	/*public transactionList[] getTransactions() {
		return transactions;
	}*/
	

	public int getAccountNumber() {
		return accountNumber;
	}	

}
