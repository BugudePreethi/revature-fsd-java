import java.util.Scanner;

public class CharCount {

	public static char count(String S){
        char result;
        String alphabets = "abcdefghijklmnopqrstuvwxyz";
        int s = 0;
        int l = S.length();
        char A[] = new char[l]; 
        for(int i = 0; i < l; i++){
            A[i] = S.charAt(i);
            if(A[i] == '*'){
                s++;
            }
        } 
        result = alphabets.charAt(s-1);
        System.out.println(alphabets.charAt(s-1));
        System.out.println(alphabets.charAt(l-s-1));
        return result;

    }


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        String S = sc.nextLine();
        System.out.println(count(S));
	}
}
