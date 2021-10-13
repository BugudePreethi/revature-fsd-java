import java.util.Scanner;

public class Palindrome {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String data = scanner.nextLine();
		int l = data.length();
		if(l % 2 == 0) {
			for(int i = 0; i < l-1 ;i++) {
				System.out.println(i);
			}
		}
	}

}
