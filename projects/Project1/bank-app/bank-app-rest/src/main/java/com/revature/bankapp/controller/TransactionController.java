package com.revature.bankapp.controller;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.bankapp.dao.TransactionDao;
import com.revature.bankapp.dao.impl.TransactionDaoImpl;
import com.revature.bankapp.exception.AppException;
import com.revature.bankapp.model.Transaction;

@Path("/transactions")
public class TransactionController {
	private static final Logger LOGGER = LoggerFactory.getLogger(TransactionController.class);
	private TransactionDao dao = new TransactionDaoImpl();
	
	//For viewing transaction List
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response get(@PathParam("id") int id) {
		LOGGER.info("Transaction controller list Start");
		Transaction transaction = new Transaction();
		transaction.setAccount_id(id);
		LOGGER.info("account Id : " + transaction.getAccount_id());
		List<Transaction> transactionList;
		try {
			transactionList = dao.list();
			return Response.ok().entity(transactionList).build();
		} catch(AppException e) {
			return Response.status(500).build();
		}
	}
}
