package com.revature.bankapp.menu;

public class CustomerMainMenu extends Menu{
	
	public  CustomerMainMenu(String name) {
		super(name);
		addMenuItem("View Accounts");
		addMenuItem("Create Account");
	}
	
	@Override
	void handleAction() {
		
	}
}
