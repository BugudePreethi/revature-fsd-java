package com.revature.bankapp.main;

import java.util.Scanner;

public class BankApp {
	
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		MainMenu mainMenu = new MainMenu("Main Menu");
		mainMenu.displayAndHandleMenuAction();
	}
	
	public static Scanner getScanner() {
		return scanner;
	}

}
