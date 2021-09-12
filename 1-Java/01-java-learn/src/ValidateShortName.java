import java.util.Scanner;
public class ValidateShortName {
	public static void main(String[] args) {
		System.out.println("Enter Short Name");
		Scanner scanner = new Scanner(System.in);
		String name = scanner.nextLine();
		scanner.close();
		int len = name.length();
		if (len >= 2 && len <= 6) {
			System.out.println("This is a Valid Short Name");
		} else {
			System.out.println("This is not Valid Short Name");
		}
	}

}
