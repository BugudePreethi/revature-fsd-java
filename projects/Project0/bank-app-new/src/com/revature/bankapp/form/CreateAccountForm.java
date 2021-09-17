package com.revature.bankapp.form;

import com.revature.bankapp.model.Balance;
import com.revature.bankapp.model.DataManager;

public class CreateAccountForm extends Form{
	private double accountNumber;
	
	public CreateAccountForm(String name) {
		super(name);
	}
	@Override
	public void captureData() {
		DataManager.getAccountNumber(accountNumber);
		System.out.print("Account Number : " + accountNumber);
		Balance balance = new Balance();
		balance.setBalance(2000);
		System.out.print("Balance : " + balance);
	}
	@Override
	public void action() {
		Balance balance_init = new Balance();
		double balance = balance_init.getBalance();
		if (balance < 2000) {
			System.out.println("Initial Balance must be greater than or equals to 2000");
		} else {
			System.out.println("Account is created successfully");
		}
	}
	
}
