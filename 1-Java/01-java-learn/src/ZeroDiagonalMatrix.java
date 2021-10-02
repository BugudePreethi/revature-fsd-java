import java.util.Scanner;

public class ZeroDiagonalMatrix {

	public static void main(String[] args) {
		int n;
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		int[][] arr = new int[n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(i == 0 || j == 0 || i == n-1 || j == n-1) {
					arr[i][j] = 1;
				} else if(i == j || i+j == n-1) {
					arr[i][j] = 2;
				}else {
					arr[i][j] = 0;
				}
				System.out.print(arr[i][j]);
			}
			System.out.print("\n");
		}
		scanner.close();
	}

}
