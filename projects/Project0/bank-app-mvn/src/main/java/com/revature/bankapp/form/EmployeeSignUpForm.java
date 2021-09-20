package com.revature.bankapp.form;

import java.sql.SQLException;
import java.util.Scanner;

import com.revature.bankapp.dao.EmployeeDao;
import com.revature.bankapp.dao.impl.EmployeeDaoImpl;
import com.revature.bankapp.main.BankApp;
import com.revature.bankapp.menu.EmployeeMenu;
import com.revature.bankapp.model.Employee;

public class EmployeeSignUpForm extends Form {
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	
	public EmployeeSignUpForm(String name) {
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
		EmployeeDao dao = new EmployeeDaoImpl();
		try {
			dao.create(new Employee(firstName, lastName, email, password, id));
		} catch (SQLException e) {
			System.out.println("Error in creating Employee");
		}
		System.out.println("Employee added successfully");
		EmployeeMenu menu = new EmployeeMenu("EmployeeMainMenu");
		menu.displayMenuAndCaptureSelection();
		success = true;
	}
}
