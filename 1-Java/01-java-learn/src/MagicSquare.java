
public class MagicSquare {

	public static void main(String[] args) {
		int n = 5;
		int[][] sqr = new int [n][n];
		int sr = 2, sc = 2, tr = 0, tc = 0;
		for (int num = 1; num <= n*n; num++) {
			
			//check boundary			
//			sr--;
//			if(sr < 0) sr = n-1;
//			sc++;
//			if(sc > n-1) sc = 0;
			
			//If the element is already filled
			if(sqr[sr][sc] == 0) {
				sqr[sr][sc] = num;
				tr = sr;
				tc = sc;
			} else {
				sr = tr;
				sc = tc;
				sr = ++sr > n - 1 ? 0 : sr;
				sqr[sr][sc] = num;
			}
			sr = --sr < 0 ? n - 1 : sr;
			sc = ++sc > n - 1 ? 0 : sc;
		}
		 for(int r = 0; r < n; r++) {
			 for(int c = 0; c < n; c++) {
				 System.out.print(String.format("%3d", sqr[r][c]));
			 }
			 System.out.println();
		 }
	}

}
