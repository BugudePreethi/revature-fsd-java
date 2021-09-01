
public class AccountManager {

	public static void main(String[] args) {
		String accountNumber = "01302343794";
		double balance = 5000.0;
		
		System.out.println("Account Statement of " + accountNumber);
		System.out.println("Initial Balance: " + balance);
		
		System.out.println("\n------------------------");
		System.out.println("Type Transaction Balance");
		System.out.println("------------------------");
		
		/*char type ='W';
		double transaction = 2000.0;
		balance = balance  - transaction;
		System.out.printf("  %c %12.2f %8.2f\n", type, transaction, balance);
		
		type ='D';
		transaction = 20000.0;
		balance = balance  + transaction;
		System.out.printf("  %c %12.2f %8.2f\n", type, transaction, balance);
		
		type ='D';
		transaction = 500.0;
		balance = balance  + transaction;
		System.out.printf("  %c %12.2f %8.2f\n", type, transaction, balance);
		
		type ='W';
		transaction = 15500.0;
		balance = balance  - transaction;
		System.out.printf("  %c %12.2f %8.2f\n", type, transaction, balance);
		
		type ='W';
		transaction = 10000.0;
		balance = balance  - transaction;
		System.out.printf("  %c %12.2f %8.2f\n", type, transaction, balance);*/
		balance = calculateBalance('W', 2000, balance);
		balance = calculateBalance('D', 20000, balance);
		balance = calculateBalance('D', 500, balance);
		balance = calculateBalance('W', 15500, balance);
		balance = calculateBalance('W', 10000, balance);
	}
	
	public static double calculateBalance(char type, double transaction, double balance) {
		if (type == 'W') {
			balance = balance - transaction;
		}
		if (type == 'D') {
			balance = balance + transaction;
		}
		
		System.out.printf("%4c %12.2f %8.2f\n", type, transaction,balance);
		
		return balance;
	}

}
