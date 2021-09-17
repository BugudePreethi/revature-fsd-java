package com.revature.bankapp.form;

import java.sql.SQLException;

import com.revature.bankapp.dao.CustomerDao;
import com.revature.bankapp.dao.impl.CustomerDaoImpl;
import com.revature.bankapp.model.Customer;

public class ViewAccountForm extends Form{
	private double accountNumber;
	private String firstName;
	private String lastName;
	private String email;
	
	public ViewAccountForm(String name) {
		super(name);
	}
	
	public double getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(double accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public void captureData() {
		AccountDao dao = new AccountDaoImpl();
		Account account = null;
		try {
			
		} catch (SQLException e) {
			System.out.println("Failed getting Customer.");
		}*/
		/*DataManager.getAccountNumber(accountNumber);
		.getFirstName();
		
	}

	@Override
	public void action() {
		// TODO Auto-generated method stub
		
	}
}
