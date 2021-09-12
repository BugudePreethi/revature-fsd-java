package com.revature.bankapp.menu;

import java.util.Scanner;
import com.revature.bankapp.main.BankApp;
import com.revature.bankapp.form.LoginForm;
import com.revature.bankapp.model.Customer;
import com.revature.bankapp.model.DataManager;

public class MainMenu extends Menu{

	//Passing Constructor
	public MainMenu(String name) {
		super(name);
		addMenuItem("New Customer!, register.");
		addMenuItem("Login as Customer");
		addMenuItem("Login as Employee");
		addMenuItem("Exit");
	}

	@Override
	void handleAction() {
		Scanner scanner = BankApp.getScanner();
		//Scanner scanner = new Scanner(System.in);
		switch (selection) {
		case 1:
			System.out.println("\n************************");
			System.out.println("New Customer!!, Register");
			System.out.println("************************");
			
			System.out.print("First Name: ");
			String firstName = scanner.nextLine();
			
			System.out.print("Last Name: ");
			String lastName = scanner.nextLine();
			
			System.out.print("Email: ");
			String email = scanner.nextLine();
			
			System.out.print("Password: ");
			String password = scanner.nextLine();
			
			DataManager.addCustomer(new Customer(firstName, lastName, email, password));
			System.out.println("Customer added successfully");
			displayMenuAndCaptureSelection();
			break;
		case 2:
			LoginForm loginForm = new LoginForm("Login Form");
			loginForm.captureDataAndPerformAction();
			break;
			
		}
	}
	
}
