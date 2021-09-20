package com.revature.bankapp.form;

import java.sql.SQLException;
import java.util.Scanner;

import com.revature.bankapp.dao.EmployeeDao;
import com.revature.bankapp.dao.impl.EmployeeDaoImpl;
import com.revature.bankapp.main.BankApp;
import com.revature.bankapp.menu.EmployeeMainMenu;
import com.revature.bankapp.model.Employee;

public class EmployeeLoginForm extends Form {
	private String email;
	private String password;
	
	public EmployeeLoginForm(String name) {
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
		EmployeeDao dao = new EmployeeDaoImpl();
		Employee employee = null;
		try {
			employee = dao.getEmployeeByEmail(email);
			if(employee == null) {
				System.out.println("Invalid Login. Please check your email");
			}
			else if(employee.getPassword().equals(password)) {
				System.out.println("Login Successful.");
				EmployeeMainMenu menu = new EmployeeMainMenu("Employee Menu");
				menu.displayMenuAndCaptureSelection();
				System.out.println("Welcome " + employee.getFirstName());
			} else {
				System.out.println("Invalid Login. Incorrect Password");
			}			
		} catch (SQLException e) {
			System.out.println("Failed getting Employee.");
		}
	}
	
}
