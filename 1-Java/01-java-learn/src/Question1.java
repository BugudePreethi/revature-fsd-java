import java.util.Scanner;

public class Question1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n =  scanner.nextInt();
		int length = n - 1;
		int[] array = new int[n];
		for(int i = 0; i <= length; i++) {
			array[i] = scanner.nextInt();
		}
		scanner.close();
		if(array[1] == length-1) {
			System.out.println("True");
		}
		else {
			System.out.println("False");
		}
		
	}

}