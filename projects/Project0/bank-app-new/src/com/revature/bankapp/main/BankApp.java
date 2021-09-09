package com.revature.bankapp.main;

import com.revature.bankapp.menu.MainMenu;
//import java.util.Scanner;

public class BankApp {
    //private static Scanner scanner = new Scanner(System.in);
    
    
	public static void main(String[] args) {
		//Instance for main menu
		MainMenu menu = new MainMenu("Main Menu");
		menu.displayMenuAndCaptureSelection();
		
	}
	
	/*public static Scanner getScanner() {
		return scanner;
	}*/

}
