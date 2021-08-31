import java.util.Scanner;
public class WebUrlChecker {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the website address:");
		String url = scanner.nextLine();
		scanner.close();
		if (url.startsWith("http://") || url.startsWith("https://")){
			System.out.println("This is a Web URL");
		} else {
			System.out.println("This is NOT Web URL");
		}
	}
}