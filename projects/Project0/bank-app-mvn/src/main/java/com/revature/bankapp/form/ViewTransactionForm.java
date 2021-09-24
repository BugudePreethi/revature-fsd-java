package com.revature.bankapp.form;

import java.sql.SQLException;
import java.util.List;

import com.revature.bankapp.dao.TransactionDao;
import com.revature.bankapp.dao.impl.TransactionDaoImpl;
import com.revature.bankapp.menu.ViewAccountsMenu;
import com.revature.bankapp.model.Transaction;

public class ViewTransactionForm extends Form{

	public ViewTransactionForm(String name) {
		super(name);
	}

	@Override
	public void captureData() {
//		Transaction transaction = new Transaction();
//		int account_id = transaction.getAccount_id();
	}

	@Override
	public void action() {
		TransactionDao dao = new TransactionDaoImpl();
		List<Transaction> transactionList = null;
		try {
			transactionList = dao.list();
		} catch (SQLException e) {
			System.out.println("Failed getting transaction");
		}
		transactionList.forEach(System.out::println);
		ViewAccountsMenu menu = new ViewAccountsMenu("View Accounts Menu");
		menu.displayMenuAndCaptureSelection();
		success = true;
	}

}
