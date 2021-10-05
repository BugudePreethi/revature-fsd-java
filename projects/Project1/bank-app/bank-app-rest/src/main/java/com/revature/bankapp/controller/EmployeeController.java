package com.revature.bankapp.controller;

import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
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
}
