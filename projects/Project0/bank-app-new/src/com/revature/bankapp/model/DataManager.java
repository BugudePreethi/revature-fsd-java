package com.revature.bankapp.model;

import java.util.ArrayList;
import java.util.List;

public class DataManager {
	//Static is used to avoid multiple instances of customer.
	private static List<Customer> customerList = new ArrayList<>();
	
	static {
		customerList.add(new Customer("John", "Smith", "john", "123"));
	}
	
	public static void addCustomer(Customer customer) {
		customerList.add(customer);
	}
	
	public static Customer getCustomerByEmail(String email) {
		for (Customer customer : customerList) {
			if (customer.getEmail().equals(email)) {
				return customer;
			}
		}
		return null;
	}
}
