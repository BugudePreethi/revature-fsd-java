import java.util.Scanner;

public class PasswordCheck {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter your password: ");
		String password = scanner.nextLine();
		int uc=0, lc=0, dc=0, sc=0;
		for (int i = 0; i < password.length(); i++) {
			char ch = password.charAt(i);
			if(Character.isUpperCase(ch)) {
				uc++;
			}
			else if(Character.isLowerCase(ch)) {
				lc++;
			} 
			else if(Character.isDigit(ch)) {
				dc++;
			}
			else {
				sc++;
			}
		}
		if(password.length()>=8 && uc>0 && lc>0 && dc>0 && sc>0) {
			System.out.println("Password is strong enough...");
		}
		else {
			if(password.length()< 8) {
				System.out.println("Pwd should have at least 8 chars");
			}
			if(uc==0)
				System.out.println("Uppercase missing");
			if(lc==0)
				System.out.println("Lowercase missing");
			if(dc==0)
				System.out.println("Digit missing");
			if(sc==0)
				System.out.println("Special Character missing");
		}
	}
}

