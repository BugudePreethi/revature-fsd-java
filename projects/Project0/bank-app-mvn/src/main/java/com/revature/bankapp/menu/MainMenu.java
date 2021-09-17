package com.revature.bankapp.menu;

import com.revature.bankapp.form.EmployeeForm;
import com.revature.bankapp.form.LoginForm;
import com.revature.bankapp.form.SignUpForm;

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
		switch (selection) {
		case 1:			
			SignUpForm signUpForm = new SignUpForm("SignUp");
			signUpForm.captureDataAndPerformAction();
			break;
		case 2:
			LoginForm loginForm = new LoginForm("Login");
			loginForm.captureDataAndPerformAction();
			break;
		case 3:
			EmployeeForm employeeForm = new EmployeeForm("Employee Form");
			employeeForm.captureDataAndPerformAction();
			break;
		case 4:
			System.out.println("Exiting BankApp");
			break;
		}
	}
	
}
