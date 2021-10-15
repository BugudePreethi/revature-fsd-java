package com.revature.bankapp.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.bankapp.dao.EmployeeDao;
import com.revature.bankapp.dao.impl.EmployeeDaoImpl;
import com.revature.bankapp.exception.AppException;
import com.revature.bankapp.model.Customer;
import com.revature.bankapp.model.Employee;
import com.revature.bankapp.model.Transaction;

@Path("/employees")
public class EmployeeController {
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);
	private EmployeeDao dao = new EmployeeDaoImpl();
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(Employee employee) {
		LOGGER.info("Start");
		LOGGER.debug("{}",employee);
		try {
			dao.create(employee);
			LOGGER.info("End");
			return Response.ok().build();
		} catch (AppException e) {
			return Response.status(500).build();
		}
	}
	
	//For employee login
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response list() {
		LOGGER.info("Controller Start");
		Employee employee;
		try {
			employee = dao.getEmployeeByEmail("john@gmail.com");
			return Response
					.ok()
					.entity(employee)
					.build();
		} catch (AppException e) {
			return Response.status(500).build();
		}
	}
	
	//Getting Customer-details
	@GET
	@Path("/{customers}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response customerList() {
		LOGGER.info("Customer list Start");
		List<Customer> customerList;
		try {
			customerList = dao.list();
			return Response.ok().entity(customerList).build();
		} catch (AppException e) {
			return Response.status(500).build();
		}
	}
	
	//Getting Transaction List
	@GET
	@Path("/transactions/{accountNumber}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response transactionList(@PathParam("accountNumber") String accountNumber) {
		LOGGER.info("Transaction List Start");
		List<Transaction> transactionList;
		try {
			transactionList = dao.transactionList(accountNumber);
			return Response.ok().entity(transactionList).build();
		} catch(AppException e) {
			return Response.status(500).build();
		}
	}
}
