import java.util.Scanner;
public class CalculateFahrenheitScanner {

	public static void main(String[] args) {
		System.out.print("Enter Temperature in Celsius : ");
		Scanner scanner = new Scanner(System.in);
		float celsius = scanner.nextFloat();
		scanner.close();
		float fahrenheit = (celsius * 9 / 5) + 32;
		System.out.print("Temperature in Fahrenheit : " + fahrenheit);
	}
}