package com.revature.bankapp.dao.impl;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.revature.bankapp.dao.CustomerDao;
import com.revature.bankapp.model.Customer;

class CustomerDaoImplTest {

	@Test
	void testCreate_Success() {
		Customer customer = new Customer("Williams", "Smith", "williams.gmail.com", "123");
		CustomerDao dao = new CustomerDaoImpl();
		try {
			dao.create(customer);
		}catch(SQLException e){
			e.printStackTrace();
			fail("Not yet implemented");
		}
	}

}
