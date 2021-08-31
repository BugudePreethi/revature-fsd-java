import java.util.Scanner;
public class VoteEligibilityChecker {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the age");
		int age = scanner.nextInt();
		scanner.close();
		if(age < 18) {
			System.out.println("Cannot Vote");
		}
		else {
			System.out.println("Can Vote");
		}
	}
}