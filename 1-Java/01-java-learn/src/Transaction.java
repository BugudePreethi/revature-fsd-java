
public class Transaction {    //Here Transaction is the data type we created
	private char type;
	private double amount;
	
	//Constructor
	public Transaction(char type, double amount) {   //Declaration of data type should be in the specified format
		this.type = type;
		this.amount = amount;
	}
	
	//Instance Method
	public void displayTransaction(double balance) {
		System.out.printf("%4c %12.2f %8.2f\n", type, amount, balance);
	}
	
	// transaction is the object created using the class Transaction
	public static void main(String args[]){
		Transaction transaction1 = new Transaction('W', 2000);//Object is created using "Transaction" class
		Transaction transaction2 = new Transaction('D', 20000);
		Transaction transaction3 = new Transaction('D', 500);
		Transaction transaction4 = new Transaction('W', 155000);
		Transaction transaction5 = new Transaction('W', 10000);
		
		Transaction[] transactionArray = { transaction1, transaction2, transaction3, transaction4, transaction5 };
		
		for (Transaction transaction : transactionArray) {
			transaction.displayTransaction(5000);
		}
		
	}

}
