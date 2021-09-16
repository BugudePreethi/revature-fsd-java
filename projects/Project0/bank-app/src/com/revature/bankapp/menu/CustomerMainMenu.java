package com.revature.bankapp.menu;

//import java.util.ArrayList;
//import java.util.List;
import java.util.Scanner;
import com.revature.bankapp.accounts.ViewAccountMenu;
import com.revature.bankapp.accounts.CreateAccountMenu;
import com.revature.bankapp.main.BankApp;

public class CustomerMainMenu extends Menu{
	
	public CustomerMainMenu(String name) {
		super(name);
		addMenuItem("Create Accounts");
		addMenuItem("View Account");
		addMenuItem("Log Out");
	}
	
	public void addMenuItem(String menuItemName) {
		menuItems.add(menuItemName);
	}
	
	public void displayMenu() {
		System.out.println("\n");
		for(int i = 0; i < menuItems.size(); i++) {
			System.out.println((i + 1) + "." + menuItems.get(i));
		}
		System.out.print("\nEnter your choice : ");
	}
	
	public void captureSelection() {
		Scanner scanner = BankApp.getScanner();
		selection = Integer.parseInt(scanner.nextLine());
	}	
	
	public void displayMenuCustomerSelectionAndHandleAction() {
		displayMenu();
		captureSelection();
		handleAction();
	}
	
	@Override
	void handleAction() {
		switch (selection) {
		case 1:
			System.out.println("\n**************");
			System.out.println("Create Account");
			System.out.println("**************");
			CreateAccountMenu createAccountMenu = new CreateAccountMenu(10001l,2000);
			createAccountMenu.action();
			displayMenu();
			break;
		case 2:
			System.out.println("\n*************");
			System.out.println("View Accounts");
			System.out.println("*************");
			ViewAccountMenu viewAccountMenu = new ViewAccountMenu(10002l,2000);
			viewAccountMenu.action();
			displayMenu();
			break;
		}
		
	}
}
