import java.util.Scanner;
public class LoginMenu {

	public static void main(String[] args) {
		Scanner scanner =  new Scanner(System.in);
		
		String[] options = {"Customer Login", "Employee Login", "Exit"};
		for (int i = 0; i <= options.length-1; i++) {
			System.out.println(i + 1 + "." + options[i]);			
		}
		
		System.out.print("Choose an Option : ");
		int input = scanner.nextInt();		
		if (input == 1) {
			System.out.println("Enter Username");
			String c_input_name = scanner.nextLine();
			System.out.println("Enter Password");
			String c_input_password = scanner.nextLine();
			
			System.out.println("Login");	
			System.out.println("\nLogin Successfull");
			System.out.println("\nCustomer Menu");
			System.out.println("==============");
			String[] c_list = {"Create new Bank Account", "Logout"};
			
			for(int i = 0; i <= c_list.length-1; i++) {
				System.out.println( i + 1 + "." + c_list[i]);
			
			}
		}
		
	}
	

}
