package com.revature.bankapp.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.bankapp.main.BankApp;

public class DataManager {
	//Static is used to avoid multiple instances of customer.
	private static List<Customer> customerList = new ArrayList<>();
	
	static {
		customerList.add(new Customer("abc", "xyz", "abcxyz", "123"));
	}
	
	public static void addCustomer(Customer customer) {
		customerList.add(customer);
	}
	
	public static void addBalance(Balance balance) {
		return;		
	}
	
	public static Customer getCustomerByEmail(String email) {
		for (Customer customer : customerList) {
			if (customer.getEmail().equals(email)) {
				return customer;
			}
		}
		return null;
	}
	
	public static double getAccountNumber(double accountNumber) {
		Scanner scanner = BankApp.getScanner();
		accountNumber = scanner.nextDouble();
		return accountNumber;
	}
	
	public static double getBalance(Balance balance) {
		return balance.getBalance();
	}
}
