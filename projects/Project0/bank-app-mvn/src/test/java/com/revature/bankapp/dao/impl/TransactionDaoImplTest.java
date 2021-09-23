package com.revature.bankapp.dao.impl;

import static org.junit.jupiter.api.Assertions.fail;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.revature.bankapp.dao.TransactionDao;

class TransactionDaoImplTest {

	@Test
	void test() {
		TransactionDao dao = new TransactionDaoImpl();
		try {
			dao.add(null);
		} catch(SQLException e) {
			e.printStackTrace();
			fail("Not yet implemented");
		}
	}

}
