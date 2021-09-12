package com.revature.bankapp.menu;

import java.util.Scanner;
import com.revature.bankapp.form.LoginForm;
import com.revature.bankapp.main.BankApp;
import com.revature.bankapp.model.Customer;
import com.revature.bankapp.model.DataManager;
import com.revature.bankapp.accounts.CreateAccount;
import com.revature.bankapp.accounts.ViewAccounts;

public class CustomerMainMenu extends Menu{
	
	public  CustomerMainMenu(String name) {
		super(name);
		addMenuItem("View Accounts");
		addMenuItem("Create Account");
	}
	
	/*public void customerSelection() {
		Scanner scanner = BankApp.getScanner();
		selection = Integer.parseInt(scanner.nextLine());
	}*/
	
	@Override
	void handleAction() {
		Scanner scanner = BankApp.getScanner();
		//Scanner scanner = new Scanner(System.in);
		selection = scanner.nextInt();
		switch (selection) {
		case 1:
			System.out.println("**************");
			System.out.println("Create Account");
			System.out.println("**************\n");
			CreateAccount createAccount = new CreateAccount(accountNumber, balance);
			createAccount.dataToBeDisplayed();
		case 2:
			System.out.println("*************");
			System.out.println("View Accounts");
			System.out.println("*************\n");
			ViewAccount viewAccount = new ViewAccount(accountNumber, balance);
			viewAccount.detailsOfCustomer();
			
		}
	}
}
