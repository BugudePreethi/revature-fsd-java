import java.util.Scanner;
public class AverageStudent {
	public static void main(String[] args) {
		System.out.println("Enter the score");
		Scanner scanner = new Scanner(System.in);
		int score = scanner.nextInt();
		scanner.close();
		if (60 <= score && score <= 70) {
			System.out.print("Average Student");
		}else {
			System.out.print("Not an Average Student");
		}
	}
}