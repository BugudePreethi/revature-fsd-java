import java.util.Scanner;
public class ProfitCalculatorScanner {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the Buying Price : ");
		int buyingPrice = scanner.nextInt();
		System.out.print("Enter the Selling Price : ");
		int sellingPrice = scanner.nextInt();
		scanner.close();
		int profit = sellingPrice - buyingPrice;
		System.out.println("Profit = " + profit);
	}
}