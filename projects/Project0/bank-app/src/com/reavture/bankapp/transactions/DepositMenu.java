package com.reavture.bankapp.transactions;

import java.util.Scanner;
import com.revature.bankapp.form.Form;
import com.revature.bankapp.main.BankApp;

public class DepositMenu extends Form{
	private String type;
	private double amount;
	
	public DepositMenu(String name) {
		super(name);
	}	
	
	
	public void action() {
		
	}

	@Override
	public void captureData() {
		Scanner scanner = BankApp.getScanner();
		System.out.print("Deposit Menu");
		amount = scanner.nextDouble();
		System.out.print("Enter the amount to deposit : " + amount);
	}

}
