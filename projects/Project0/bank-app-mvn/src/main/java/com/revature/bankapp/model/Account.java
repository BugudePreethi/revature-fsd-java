package com.revature.bankapp.model;

public class Account {
	private String accountNumber;
	private double balance;
	private int customerId;
	private int id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public Account(String accountNumber, double balance) {
		super();
		this.accountNumber = accountNumber;
		this.balance = balance;
	}
	
	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", balance=" + balance + ", id=" + id + "]";
	}
	public Account() {
		super();
	}	
	
	
}
