package com.revature.bankapp.model;

import java.util.ArrayList;
import java.util.List;

public class DataManager {
	//Static is used to avoid multiple instances of customer.
	private static List<Customer> customerList = new ArrayList<>();
	
	public static Customer getCustomerByEmail(String email) {
		for (Customer customer : customerList) {
			if (customer.getEmail().equals(email)) {
				return customer;
			}
		}
		return null;
	}
}
