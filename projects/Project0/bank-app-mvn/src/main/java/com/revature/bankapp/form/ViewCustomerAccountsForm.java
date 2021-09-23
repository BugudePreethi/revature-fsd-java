package com.revature.bankapp.form;

import java.sql.SQLException;
import java.util.List;

import com.revature.bankapp.dao.EmployeeDao;
import com.revature.bankapp.dao.impl.EmployeeDaoImpl;
import com.revature.bankapp.menu.EmployeeMainMenu;
import com.revature.bankapp.model.Account;
import com.revature.bankapp.model.Customer;

public class ViewCustomerAccountsForm extends Form{

	public ViewCustomerAccountsForm(String name) {
		super(name);
	}

	@Override
	public void captureData() {
		
	}

	@Override
	public void action() {
		EmployeeDao dao = new EmployeeDaoImpl();
		List<Customer> listOfCustomers = null;
		//List<Account> listOfAccounts = null;
		try {
			listOfCustomers = dao.customerList();
			//listOfAccounts = dao.accountList();
		}catch(SQLException e) {
			System.out.println("Failed getting Customer Accounts");
		}
		listOfCustomers.forEach(System.out::println);
		EmployeeMainMenu menu = new EmployeeMainMenu("Menu");
		menu.displayMenuAndCaptureSelection();
		success = true;
	}
	
}
