import java.util.Scanner;

public class MenuDisplayingUsingLoop {

	public static void main(String[] args) {
		System.out.println("Menu");
		System.out.println("====");
		System.out.println("1. Balance Enquiry");
		System.out.println("2. Recharge");
		System.out.println("3. Change Caller Tune");
		System.out.println("4. Exit");
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Choose an Option : ");
		int option = scanner.nextInt();
		
		while(option!=0) { 
			if(option > 5) {
				System.out.println("Choose a valid Option");
				System.out.println("Menu");
				System.out.println("====");
				System.out.println("1. Balance Enquiry");
				System.out.println("2. Recharge");
				System.out.println("3. Change Caller Tune");
				System.out.println("4. Exit");
				System.out.print("Choose an Option : ");
				option = scanner.nextInt();
			} else {
				switch (option) {
				case 1:
					System.out.println("Balance Enquiry");
					System.out.println("Menu");
					System.out.println("====");
					System.out.println("1. Balance Enquiry");
					System.out.println("2. Recharge");
					System.out.println("3. Change Caller Tune");
					System.out.println("4. Exit");
					System.out.print("Choose an Option : ");
					option = scanner.nextInt();
					break;
				case 2:
					System.out.println("Recharge");
					System.out.println("Menu");
					System.out.println("====");
					System.out.println("1. Balance Enquiry");
					System.out.println("2. Recharge");
					System.out.println("3. Change Caller Tune");
					System.out.println("4. Exit");
					System.out.print("Choose an Option : ");
					option = scanner.nextInt();
					break;
				case 3:
					System.out.println("Change Caller Tune");
					System.out.println("Menu");
					System.out.println("====");
					System.out.println("1. Balance Enquiry");
					System.out.println("2. Recharge");
					System.out.println("3. Change Caller Tune");
					System.out.println("4. Exit");
					System.out.print("Choose an Option : ");
					option = scanner.nextInt();
					scanner.close();
					break;
				case 4:      //Entering into infinite loop
					System.out.println("Exit");
					break;
				}
			}
			
		}
	}

}
