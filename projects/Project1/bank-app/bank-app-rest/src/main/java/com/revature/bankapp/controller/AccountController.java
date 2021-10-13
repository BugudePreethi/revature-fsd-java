package com.revature.bankapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.bankapp.dao.AccountDao;
import com.revature.bankapp.dao.impl.AccountDaoImpl;
import com.revature.bankapp.exception.AppException;
import com.revature.bankapp.model.Account;
import com.revature.bankapp.model.Customer;

@Path("/accounts")
public class AccountController {
	private static final Logger LOGGER = LoggerFactory.getLogger(AccountController.class);
	private AccountDao dao = new AccountDaoImpl();
	
	//For creating a new account
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(Account account) {
		LOGGER.info("Start");
		LOGGER.debug("{}",account);
		try {
			dao.create(account);
			LOGGER.info("End");
			return Response.ok().build();
		} catch(AppException e) {
			return Response.status(500).build();
		}
	}
	
	//For viewing accounts
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response list(@Context HttpServletRequest request) {
		LOGGER.info("View accounts Start");
		Customer customer = (Customer) request.getSession().getAttribute("customer");
		List<Account> accountList;
		try {
			accountList = dao.list(customer.getId());
			return Response.ok().entity(accountList).build();
		} catch (AppException e) {
			return Response.status(500).build();
		}
	}
	
	//For approving accounts
	@POST
	@Path("/approve")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response approveAccount(String accountNumber) {
		LOGGER.info("Approve accounts Start");
		LOGGER.debug("{}",accountNumber);
		try {
			dao.approveAccount(accountNumber);
			LOGGER.info("End");
			return Response.ok().build();
		} catch(AppException e) {
			return Response.status(500).build();
		}
	} 
	
	//For rejecting accounts
		@POST
		@Path("/reject")
		@Consumes(MediaType.APPLICATION_JSON)
		public Response rejectAccount(String accountNumber) {
			LOGGER.info("Reject accounts Start");
			LOGGER.debug("{}",accountNumber);
			try {
				dao.approveAccount(accountNumber);
				LOGGER.info("End");
				return Response.ok().build();
			} catch(AppException e) {
				return Response.status(500).build();
			}
		}
}
