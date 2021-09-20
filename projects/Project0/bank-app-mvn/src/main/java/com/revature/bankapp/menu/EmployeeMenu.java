package com.revature.bankapp.menu;

import com.revature.bankapp.form.EmployeeLoginForm;
import com.revature.bankapp.form.EmployeeSignUpForm;

public class EmployeeMenu extends Menu{
	

	public EmployeeMenu(String name) {
		super(name);
		addMenuItem("Sign Up");
		addMenuItem("Login");
		addMenuItem("Exit");
	}

	@Override
	void handleAction() {
		switch(selection) {
		case 1:
			EmployeeSignUpForm  employeeSignUpForm = new EmployeeSignUpForm("SignUp");
			employeeSignUpForm.captureDataAndPerformAction();
			break;
		case 2:
			EmployeeLoginForm  employeeLoginForm = new EmployeeLoginForm("Login");
			employeeLoginForm.captureDataAndPerformAction();
			break;
		case 3:
			System.out.println("Exit the portal");
			break;
		}
	}
	
}
