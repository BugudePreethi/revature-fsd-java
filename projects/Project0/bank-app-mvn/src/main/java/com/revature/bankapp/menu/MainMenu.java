package com.revature.bankapp.menu;

import com.revature.bankapp.form.LoginForm;
import com.revature.bankapp.form.SignUpForm;

public class MainMenu extends Menu{
	
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
			EmployeeMenu menu = new EmployeeMenu("Employee Menu");
			menu.displayMenuAndCaptureSelection();
			break;
		case 4:
			System.out.println("Thank You for choosing our Bank");
			System.out.println("Visit Again");
			System.out.println("Exiting BankApp");
			break;
		}
	}
	
}
