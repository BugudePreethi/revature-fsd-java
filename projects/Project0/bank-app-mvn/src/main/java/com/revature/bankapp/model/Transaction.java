package com.revature.bankapp.model;

public class Transaction {
	private int account_id;
	private double amount;
	private double balance;
	private String type;
	private String accountNumber;
	
	public int getAccount_id() {
		return account_id;
	}
	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public Transaction(double amount, double balance, String type) {
		super();
		this.amount = amount;
		this.balance = balance;
		this.type = type;
	}
	public Transaction() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Transaction [account_id=" + account_id + ", type=" + type +", amount=" + amount + ", balance=" + balance + "]";
	}
	
}
