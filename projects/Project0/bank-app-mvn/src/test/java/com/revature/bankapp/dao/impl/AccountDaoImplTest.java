package com.revature.bankapp.dao.impl;

import static org.junit.jupiter.api.Assertions.fail;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.revature.bankapp.dao.AccountDao;
import com.revature.bankapp.model.Account;

class AccountDaoImplTest {

	@Test
	void testCreate_Success() {
		Account account = new Account(100001, 2000);
		AccountDao dao = new AccountDaoImpl();
		try {
			dao.create(account);
		} catch(SQLException e) {
			e.printStackTrace();
			fail("Not yet implemented");
		}
	}

}
