
public class ProfitCalculatorFunction {

	public static void main(String[] args) {
		System.out.println("Profit : " + profitFun(15, 20));
	}
	
	public static int profitFun(int buyingPrice, int sellingPrice) {
		int profit = sellingPrice - buyingPrice;
		return profit;
	}

}
