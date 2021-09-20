package com.revature.bankapp.dao.impl;

import static org.junit.jupiter.api.Assertions.fail;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.revature.bankapp.dao.AccountDao;
import com.revature.bankapp.model.Account;

class AccountDaoImplTest {

	@Test
	void testCreate_Success() {
		/*Customer customer = new Customer();
		customer.setId(1);
		BankApp.setCurrentCustomer(customer);*/
		//Account account = new Account(100003, 2000);
		AccountDao dao = new AccountDaoImpl();
		try {
			//dao.create(account);
			dao.list();
			//Account account = new Account();
			//dao.get(balance);
		} catch(SQLException e) {
			e.printStackTrace();
			fail("Not yet implemented");
		}
	}

}
