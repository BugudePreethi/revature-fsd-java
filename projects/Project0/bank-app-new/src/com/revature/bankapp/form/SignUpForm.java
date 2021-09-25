package com.revature.bankapp.form;

import java.util.Scanner;

import com.revature.bankapp.main.BankApp;

public class SignUpForm extends Form{
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	
	public SignUpForm(String name) {
		super(name);
	}
	
	@Override
	public void captureData() {
		Scanner scanner = BankApp.getScanner();
		System.out.print("First Name : ");
		firstName = scanner.nextLine();
		
		System.out.print("Last Name : ");
		lastName = scanner.nextLine();
		
		System.out.print("Email : ");
		email = scanner.nextLine();
		
		System.out.print("Password : ");
		password = scanner.nextLine();
		
	}

	@Override
	public void action() {
//		CustomerDao dao = new CustomerDaoImpl();
//		try {
//			dao.create(new Customer(firstName, lastName, email, password));
//		} catch (SQLException e) {
//			System.out.println("Error in creating Customer");
//		}
//		System.out.println("Customer added successfully");
//		menu.displayMenuAndCaptureSelection();
		/*DataManager.addCustomer(new Customer(firstName, lastName, email, password));
		System.out.println("Customer added successfully");
		CustomerMainMenu menu = new CustomerMainMenu("New Customer Menu");
		menu.displayMenuAndCaptureSelection();*/
	}
}
