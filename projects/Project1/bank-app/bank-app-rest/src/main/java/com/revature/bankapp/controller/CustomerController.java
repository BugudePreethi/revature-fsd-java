package com.revature.bankapp.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.bankapp.dao.CustomerDao;
import com.revature.bankapp.dao.impl.CustomerDaoImpl;
import com.revature.bankapp.exception.AppException;
import com.revature.bankapp.model.Customer;

@Path("/customers")
public class CustomerController {
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);
	private CustomerDao dao = new CustomerDaoImpl();
	
	//For customer signup
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(Customer customer){
		LOGGER.info("Start");
    	LOGGER.debug("{}",customer);
		try {
			dao.create(customer);
			LOGGER.info("End");
			return Response.ok().build();
		} catch (AppException e) {
			return Response.status(500).build();
		}
	}
	
	
	//For customer login
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response list() {
		LOGGER.info("Controller Start");
		Customer customer;
		try {
			customer = dao.getCustomerByEmail("john@xyz.com");
			return Response.ok().entity(customer).build();
		} catch (AppException e) {
			return Response.status(500).build();
		}
	}
}
