package com.revature.bankapp.menu;

import com.revature.bankapp.form.TransferForm;
import com.revature.bankapp.form.ViewAccountsForm;
import com.revature.bankapp.form.ViewBalanceForm;
import com.revature.bankapp.form.ViewTransactionForm;

public class ViewAccountsMenu extends Menu{

	public ViewAccountsMenu(String name) {
		super(name);
		addMenuItem("View Accounts");
		addMenuItem("View Balance");
		addMenuItem("View Transactions");
		addMenuItem("Transfer");
		addMenuItem("Back to Menu");
	}

	@Override
	void handleAction() {
		switch(selection) {
		case 1:
			ViewAccountsForm viewAccountsForm = new ViewAccountsForm("List of Accounts");
			viewAccountsForm.captureDataAndPerformAction();
			break;
		case 2:
			ViewBalanceForm viewBalanceForm = new ViewBalanceForm("View Balance");
			viewBalanceForm.captureDataAndPerformAction();
			break;
		case 3:
			ViewTransactionForm viewTransactionForm = new ViewTransactionForm("Transactions");
			viewTransactionForm.captureDataAndPerformAction();
			break;
		case 4:
			TransferForm transferForm = new TransferForm("Transfer Form");
			transferForm.captureDataAndPerformAction();
			break;
		case 5:
			System.out.println("Back to Menu");
		}
	}

}
