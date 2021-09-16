package com.revature.bankapp.menu;

import java.util.Scanner;

import com.revature.bankapp.main.BankApp;

public class CustomerMainMenu extends Menu{
	
	public  CustomerMainMenu(String name) {
		super(name);
		addMenuItem("View Accounts");
		addMenuItem("Create Account");
		addMenuItem("Logout");
	}
	
	public void displayMenu() {
		System.out.println("*************");
		System.out.println("name");
		System.out.println("*************\n");
		for (int i = 0; i < menuItems.size(); i++) {
			System.out.println((i + 1) + "." + menuItems.get(i));
		}
		System.out.print("\n Enter your choice : ");
	}
	@Override
	void handleAction() {
		Scanner scanner = BankApp.getScanner();
		switch (selection) {
		case 1:
			System.out.println("**************");
			System.out.println("Create Account");
			System.out.println("**************\n");
			
			System.out.print("balance : ");
			
			System.out.print("Account Number : ");
			
						
		}
	}
}
