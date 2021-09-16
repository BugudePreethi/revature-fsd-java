package com.reavture.bankapp.transactions;

import java.util.Scanner;
import com.revature.bankapp.main.BankApp;

public class WithdrawlMenu {
	private String type;
	private double amount;
	
	public WithdrawlMenu(String type, double amount) {
		super();
		this.type = type;
		this.amount = amount;
	}
	
	public void action() {
		Scanner scanner = BankApp.getScanner();
		type = scanner.next();
		System.out.print("Withdrawal Menu");
		amount = scanner.nextDouble();
		System.out.print("Enter the amount to withdraw : " + amount);
	}
	
}
