package com.revature.bankapp.form;

import com.revature.bankapp.model.Customer;
import com.revature.bankapp.model.DataManager;
import com.revature.bankapp.menu.CustomerMainMenu;
import java.util.Scanner;

public class LoginForm extends Form {
	private String email;
	private String password;
	public LoginForm(String name) {
		super(name);
	}

	@Override
	public void captureData() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Email : ");
		email = scanner.nextLine();
		
		System.out.println("Password : ");
		password = scanner.nextLine();
		
		
	}

	@Override
	public void action() {
		Customer customer = DataManager.getCustomerByEmail(email);
		if(customer == null) {
			System.out.println("Invalid Email/Password");
		}
		if(customer.getPassword().equals(password)) {
			System.out.println("Login Successful.");
			CustomerMainMenu menu = new CustomerMainMenu("CustomerMainMenu");
			menu.displayMenuAndCaptureSelection();
			System.out.println("Welcome " + customer.getFirstName());
		} else {
			System.out.println("Invalid Login. Please check your details");
		}
	}
	
	
}
