import java.util.Scanner;

public class Demo1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
//		int n = scanner.nextInt();
//		for(int i  = 1; i <= 10; i++) {
//			System.out.println(String.format("%2d",n) + " x " + String.format("%2d", i) + " = " +String.format("%2d", (n*i)));
//		}
		System.out.print("Please enter a string : ");
		String data = scanner.nextLine();
		
		String[] words =data.split(" ");
		for (int i = 0; i < words.length; i++) {
			for (int j = words[i].length()-1; j >= 0; j--) {
				System.out.print(words[i].charAt(j));
			}
			System.out.println();
		}
		scanner.close();
	}

}
