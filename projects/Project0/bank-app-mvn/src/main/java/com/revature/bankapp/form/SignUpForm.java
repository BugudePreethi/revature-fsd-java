package com.revature.bankapp.form;

import java.sql.SQLException;
import java.util.Scanner;

import com.revature.bankapp.dao.CustomerDao;
import com.revature.bankapp.dao.impl.CustomerDaoImpl;
import com.revature.bankapp.main.BankApp;
import com.revature.bankapp.menu.MainMenu;
import com.revature.bankapp.model.Customer;

public class SignUpForm extends Form{
	//private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	//private double mobileNumber;
	
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
		
		//System.out.print("Mobile Number : ");
		//mobileNumber = scanner.nextDouble();
		
	}

	@Override
	public void action() {
		CustomerDao dao = new CustomerDaoImpl();
		try {
			dao.create(new Customer (firstName, lastName, email, password));
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error in creating Customer");
		}
		System.out.println("Customer added successfully");
		MainMenu menu = new MainMenu("MainMenu");
		menu.displayMenuAndCaptureSelection();
		success = true;
	}
}
