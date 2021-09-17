package com.revature.bankapp.main;

import java.util.Scanner;
import com.revature.bankapp.menu.MainMenu;
import com.revature.bankapp.model.Customer;

public class BankApp {

	private static Scanner scanner = new Scanner(System.in);

	private static Customer currentCustomer = null;

	public static Customer getCurrentCustomer() {
		return currentCustomer;
	}

	public static void setCurrentCustomer(Customer customer) {
		currentCustomer = customer;
	}

	public static void main(String[] args) {

		MainMenu menu = new MainMenu("Main Menu");
		menu.displayMenuAndCaptureSelection();

	}

	public static Scanner getScanner() {
		return scanner;
	}

}
