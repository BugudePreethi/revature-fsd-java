package com.revature.bankapp.form;

import com.revature.bankapp.main.BankApp;
import com.revature.bankapp.model.Account;

public class TransactionsForm extends Form{

	public TransactionsForm(String name) {
		super(name);
	}

	@Override
	public void captureData() {
		BankApp.getCurrentCustomer();
		
	}

	@Override
	public void action() {
		Account account = new Account();
		System.out.println("Account Statement of " + account.getAccountNumber());
		System.out.println("Initial Balance: " + account.getBalance());
		
		System.out.println("\n------------------------");
		System.out.println("Type Transaction Balance");
		System.out.println("------------------------");
		ViewTransactionForm viewTransactionForm = new ViewTransactionForm("Form"); 
	}

}
