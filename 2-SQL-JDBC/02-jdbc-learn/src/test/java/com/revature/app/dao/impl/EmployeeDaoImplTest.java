package com.revature.app.dao.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.revature.app.dao.EmployeeDao;

class EmployeeDaoImplTest {

	@Test
	void test() {
		EmployeeDao dao = new EmployeeDaoImpl();
		try {
			assertTrue(dao.list().size() > 0);
		} catch (SQLException e) {
			e.printStackTrace();
			fail("Getting employee list failed");
		}
	}

}
