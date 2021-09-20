package com.revature.bankapp.form;

import java.sql.SQLException;
import java.util.List;

import com.revature.bankapp.dao.AccountDao;
import com.revature.bankapp.dao.impl.AccountDaoImpl;
import com.revature.bankapp.menu.CustomerMainMenu;
import com.revature.bankapp.model.Account;

public class ViewAccountsForm extends Form{

	public ViewAccountsForm(String name) {
		super(name);
	}

	@Override
	public void captureData() {
		
	}

	@Override
	public void action() {
		AccountDao dao = new AccountDaoImpl();
		List<Account> accountList = null;
		try {
			accountList = dao.list();
		} catch (SQLException e) {
			System.out.println("Failed getting Customer.");
		}
		accountList.forEach(System.out::println);
		CustomerMainMenu menu = new CustomerMainMenu("CustomerMainMenu");
		menu.displayMenuAndCaptureSelection();
		success = true;
	}
	
}
