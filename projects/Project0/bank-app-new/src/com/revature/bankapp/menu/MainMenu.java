package com.revature.bankapp.menu;

public class MainMenu extends Menu{

	//Passing Constructor
	public MainMenu(String name) {
		super(name);
		addMenuItems("New Customer!, register.");
		addMenuItems("Login as Customer");
		addMenuItems("Login as Employee");
		addMenuItems("Exit");
	}

	@Override
	void handleAction() {
		System.out.println("Selected option is : " + selection);
	}
	
	
}
