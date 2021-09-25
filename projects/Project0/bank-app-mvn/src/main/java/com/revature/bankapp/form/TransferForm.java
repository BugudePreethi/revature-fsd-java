package com.revature.bankapp.form;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.revature.bankapp.dao.AccountDao;
import com.revature.bankapp.dao.impl.AccountDaoImpl;
import com.revature.bankapp.main.BankApp;
import com.revature.bankapp.model.Account;

public class TransferForm extends Form{
	private int account_id;
	private int account_id1;
	private double amount;
	private double balance;
	private double balance1;

	public TransferForm(String name) {
		super(name);
	}

	public int getAccount_id() {
		return account_id;
	}

	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}

	public int getAccount_id1() {
		return account_id1;
	}

	public void setAccount_id1(int account_id1) {
		this.account_id1 = account_id1;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getBalance1() {
		return balance1;
	}

	public void setBalance1(double balance1) {
		this.balance1 = balance1;
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
		System.out.print("Choose an account_id from the given list of accounts");
		System.out.println("Enter the account Id of the sender : ");
		account_id = scanner.nextInt();//Amount transfered from this account
		System.out.println("Enter the account__id in which amount needs to be transfered : ");
		account_id1 = scanner.nextInt();//Amount transfered to this account
		System.out.print("Enter the amount to be sent : ");
		amount = scanner.nextDouble();
//		Account account = new Account();
//		balance = account.getBalance();
//		Account account1 = new Account();
//		balance1 = account1.getBalance();
	}

	@Override
	public void action() {
		System.out.print("Balance of sender account_id: ");
		AccountDao bDao = new AccountDaoImpl();
		try {
			balance = bDao.showBalance(account_id);
			balance1 = bDao.showBalance(account_id1);
		} catch (SQLException e) {
			System.out.println("Failed getting balance");
		}
		balance = balance - amount;
		balance1 = balance1 + amount;
//		AccountDao dao = new AccountDaoImpl();
//		try {
//			Account account = new Account();
//			dao.update(account);
//			System.out.println("Account is updated Successfully");
//		} catch(SQLException e) {
//			System.out.println("Error in transfering the account");
//		}
		
	}

}
