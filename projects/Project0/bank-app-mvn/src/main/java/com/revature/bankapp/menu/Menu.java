package com.revature.bankapp.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.revature.bankapp.main.BankApp;

public abstract class Menu {
	
	protected String name;
	protected List<String> menuItems;
	protected int selection;
	
	//Instantiating the variable 
	public Menu(String name) {
		this.name = name;
		menuItems = new ArrayList<>();
	}
	
	//Adding the items to list
	public void addMenuItem(String menuItemName) {
		menuItems.add(menuItemName);
	}
	
	//We can display menu using this function
	public void displayMenu() {
		System.out.println("****");
		System.out.println(name);
		System.out.println("****");
		for (int i = 0; i < menuItems.size(); i++) {
			System.out.println((i + 1) + "." + menuItems.get(i));
		}
		System.out.print("\nEnter your choice : ");
	}
	
	public void captureSelection() {
		Scanner scanner = BankApp.getScanner();
		selection = Integer.parseInt(scanner.nextLine());
	}
	
	//Method to display action in order
	public void displayMenuAndCaptureSelection() {
		int validOption = 1;
		while(validOption == 1) {
			try {
				displayMenu();
				captureSelection();
				if(selection > 0 && selection <= menuItems.size()) {
					validOption = 0;
				} else {
					System.out.println("Select value between  1 - " + menuItems.size() + "\n");
				}
			} catch(NumberFormatException e) {
				System.out.println("Please enter valid number");
			}
		}
		handleAction();
	}
	
	abstract void handleAction();

}
