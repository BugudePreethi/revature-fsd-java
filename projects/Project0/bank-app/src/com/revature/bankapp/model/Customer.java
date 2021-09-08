package com.revature.bankapp.model;

public class Customer {
	private long id;
	private String first_name;
	private String last_name;
	private String email;
	private String password;

	public long getId() {
		return id;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
