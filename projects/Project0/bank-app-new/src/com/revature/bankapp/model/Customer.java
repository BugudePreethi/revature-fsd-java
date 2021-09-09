package com.revature.bankapp.model;

//import java.util.List;

public class Customer {
	private long id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	//private List<Account> accountList;
	
	//Counter is a unique identifier for each object
	private static long counter = 0;
	
	public Customer(String firstName, String lastName, String email, String password) {
		super();
		counter++;
		this.id = counter;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}

	public long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}
	
	
}
