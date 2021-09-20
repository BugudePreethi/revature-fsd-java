package com.revature.bankapp.form;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.revature.bankapp.dao.AccountDao;
import com.revature.bankapp.dao.impl.AccountDaoImpl;
import com.revature.bankapp.main.BankApp;
import com.revature.bankapp.model.Account;

public class TransferForm extends Form{
	private double accountNumber;
	private double accountNumber1;
	private double amount;
	private double balance;
	private double balance1;

	public TransferForm(String name) {
		super(name);
	}

	@Override
	public void captureData() {
		Scanner scanner = BankApp.getScanner();
		AccountDao dao = new AccountDaoImpl();
		List<Account> accountList = null;
		try {
			accountList = dao.list();
		} catch (SQLException e) {
			System.out.println("Failed getting Customer.");
		}
		accountList.forEach(System.out::println);
		System.out.print("Choose an account from the given list of accounts");
		accountNumber = scanner.nextDouble();//Amount transfered from this account
		accountNumber1 = scanner.nextDouble();//Amount transfered to this account
		System.out.print("Enter the amount : ");
		amount = scanner.nextDouble();
		Account account = new Account();
		balance = account.getBalance();
		Account account1 = new Account();
		balance1 = account1.getBalance();
	}

	@Override
	public void action() {
		balance = balance - amount;
		balance1 = balance1 + amount;
		
	}

}
