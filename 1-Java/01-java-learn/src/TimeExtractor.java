import java.util.Scanner;
public class TimeExtractor {

	public static void main(String[] args) {
		System.out.println("Enter Time in hh:mm:ss format");
		Scanner scanner = new Scanner(System.in);
		String time = scanner.nextLine();
		scanner.close();
		String min = time.substring(3,5);
		System.out.println(min);
	}

}
