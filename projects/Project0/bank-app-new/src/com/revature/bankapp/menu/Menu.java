package com.revature.bankapp.menu;

import java.util.ArrayList;
//import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

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
	public void addMenuItems(String menuItemName) {
		menuItems.add(menuItemName);
	}
	
	//We can display menu using this function
	public void displayMenu() {
		System.out.println("Menu");
		System.out.println("****");
		for (int i = 0; i < menuItems.size(); i++) {
			System.out.println((i + 1) + "." + menuItems.get(i));
		}
		System.out.print("\nEnter your choice : ");
	}
	
	//Task to select valid option
	public void captureSelection() {
		int validOption = 0;
		while(validOption == 0) {
			try {
				Scanner scanner = new Scanner(System.in);
				selection = Integer.parseInt(scanner.nextLine());
				
				if(selection > 0 && selection <=menuItems.size()) {
					validOption = 1;//Loop doesnot terminate here
				} else {
					System.out.println("Please select the option between 1 - " + menuItems.size() + "\n");
					displayMenuAndCaptureSelection();
				}
				
			} catch(NumberFormatException e) {
				System.out.println("Please select a valid option");
				displayMenuAndCaptureSelection();
			}
		}
	}
	
	//Method to display action in order
	public void displayMenuAndCaptureSelection() {
		displayMenu();
		captureSelection();
		handleAction();
	}
	
	//This groups all the actions together
	abstract void handleAction();

}
