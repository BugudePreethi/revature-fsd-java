package com.revature.bankapp.model;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class Transaction {
	private int account_id;
	private double amount;
	private double balance;
	private String type;
	SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
	
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
	public SimpleDateFormat getDate() {
		return date;
	}
	public void setDate(Date date2) {
		this.date = date2;
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
		return "Transaction [account_id=" + account_id + ", type=" + type +", amount=" + amount + ", balance=" + balance + ", date=" + date + "]";
	}
	
}
