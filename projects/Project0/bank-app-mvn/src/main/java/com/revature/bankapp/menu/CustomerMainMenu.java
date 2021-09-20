package com.revature.bankapp.menu;

import com.revature.bankapp.form.CreateAccountForm;
import com.revature.bankapp.main.BankApp;

public class CustomerMainMenu extends Menu{
	
	public  CustomerMainMenu(String name) {
		super(name);
		addMenuItem("Create Account");
		addMenuItem("View Accounts");
		addMenuItem("LogOut");
	}

	@Override
	void handleAction() {
		switch(selection) {
		case 1:
			CreateAccountForm createAccountForm = new CreateAccountForm("Create Account");
			createAccountForm.captureDataAndPerformAction();
			break;
		case 2:
			ViewAccountsMenu viewAccountsMenu = new ViewAccountsMenu("View Accounts");
			viewAccountsMenu.displayMenuAndCaptureSelection();
			break;
		case 3:
			BankApp.setCurrentCustomer(null);
			MainMenu mainMenu = new MainMenu("Menu");
			mainMenu.displayMenuAndCaptureSelection();
		}
	}
	
	
}
