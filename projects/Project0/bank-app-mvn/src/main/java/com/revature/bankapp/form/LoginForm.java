package com.revature.bankapp.form;

import java.sql.SQLException;
import java.util.Scanner;

import com.revature.bankapp.dao.CustomerDao;
import com.revature.bankapp.dao.impl.CustomerDaoImpl;
import com.revature.bankapp.main.BankApp;
import com.revature.bankapp.menu.CustomerMainMenu;
import com.revature.bankapp.model.Customer;

public class LoginForm extends Form {
	private String email;
	private String password;

	public LoginForm(String name) {
		super(name);
	}

	@Override
	public void captureData() {
		Scanner scanner = BankApp.getScanner();
		System.out.print("Email : ");
		email = scanner.nextLine();

		System.out.print("Password : ");
		password = scanner.nextLine();
		
	}

	@Override
	public void action() {
		CustomerDao dao = new CustomerDaoImpl();
		Customer customer = null;
		try {
			customer = dao.getCustomerByEmail(email);
			if(customer == null) {
				System.out.println("Invalid Login. Please check your email");
			}
			else if(customer.getPassword().equals(password)) {
				System.out.println("Login Successful.");
				BankApp.setCurrentCustomer(customer);				
				CustomerMainMenu menu = new CustomerMainMenu("CustomerMainMenu");
				menu.displayMenuAndCaptureSelection();
				System.out.println("Welcome " + customer.getFirstName());
			} else {
				System.out.println("Invalid Login. Incorrect Password");
			}			
		} catch (SQLException e) {
			System.out.println("Failed getting Customer.");
		}
	}

}
