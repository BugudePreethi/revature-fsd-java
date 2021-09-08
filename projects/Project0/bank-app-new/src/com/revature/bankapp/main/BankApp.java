package com.revature.bankapp.main;

import com.revature.bankapp.menu.MainMenu;

public class BankApp {

	public static void main(String[] args) {
		//Instance for main menu
		MainMenu menu = new MainMenu("Main Menu");
		menu.displayMenuAndCaptureSelection();
	}

}
