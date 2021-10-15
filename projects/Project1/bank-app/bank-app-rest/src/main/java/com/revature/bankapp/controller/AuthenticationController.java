package com.revature.bankapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.bankapp.dao.CustomerDao;
import com.revature.bankapp.dao.impl.CustomerDaoImpl;
import com.revature.bankapp.exception.AppException;
import com.revature.bankapp.model.Customer;

@Path("/authenticate")
public class AuthenticationController {
	private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);
	private CustomerDao dao = new CustomerDaoImpl();
	
//	@POST
//	@Consumes(MediaType.APPLICATION_JSON)
//	public Response login(Customer credentials, @Context HttpServletRequest request) {
//		LOGGER.info("Start");
//		LOGGER.debug("{}", credentials);
//		LOGGER.debug("Session Id: "+ request.getSession().getId());
//		try {
//			Customer customer = dao.getCustomerByEmail(credentials.getEmail());
//			LOGGER.debug("{}", customer);
//			if (customer == null || !customer.getPassword().equals((credentials.getPassword()))){
//				return Response.status(404).build();
//			}
//			if (customer.getPassword().equals(credentials.getPassword())) {
//				request.getSession().setAttribute("customer", customer);
//				return Response.ok().build();
//			}
//			LOGGER.info("End");
//			return Response.ok().build();
//		} catch (AppException e) {
//			return Response.status(500).build();
//		}
//	}
}
