package com.revature.bankapp.form;

import java.sql.SQLException;
import java.util.List;

import com.revature.bankapp.dao.AccountDao;
import com.revature.bankapp.dao.impl.AccountDaoImpl;
import com.revature.bankapp.model.Account;

public class ApproveAccountForm extends Form{

	public ApproveAccountForm(String name) {
		super(name);
	}

	@Override
	public void captureData() {
		AccountDao dao = new AccountDaoImpl();
		List<Account> accountList = null;
		try {
			accountList = dao.list();
		} catch (SQLException e) {
			System.out.println("Failed getting Customer.");
		}
		accountList.forEach(System.out::println);
		
	}

	@Override
	public void action() {
		
	}

}
