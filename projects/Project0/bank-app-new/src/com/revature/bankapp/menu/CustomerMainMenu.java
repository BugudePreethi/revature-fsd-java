package com.revature.bankapp.menu;

import com.revature.bankapp.form.CreateAccountForm;
import com.revature.bankapp.form.ViewAccountForm;

public class CustomerMainMenu extends Menu{
	
	public  CustomerMainMenu(String name) {
		super(name);
		addMenuItem("View Accounts");
		addMenuItem("Create Account");
		addMenuItem("Logout");
	}
	
	public void displayMenu() {
		System.out.println("*************");
		System.out.println("name");
		System.out.println("*************\n");
		for (int i = 0; i < menuItems.size(); i++) {
			System.out.println((i + 1) + "." + menuItems.get(i));
		}
		System.out.print("\n Enter your choice : ");
	}
	@Override
	void handleAction() {	
		switch (selection) {
		case 1:
			CreateAccountForm createAccountForm = new CreateAccountForm("Create Account");
			createAccountForm.captureDataAndPerformAction();
			break;
		/*case 2:
			ViewAccountForm viewAccountForm = new ViewAccountForm("View Accounts");
			viewAccountForm.captureDataAndPerformAction();
			break;*/
		}
	}
}
