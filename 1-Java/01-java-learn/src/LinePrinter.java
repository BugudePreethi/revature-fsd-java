
public class LinePrinter {

	public static void main(String[] args) {
		printLine();
		printLine(15);
		printLine(30,'A');
		//LinePrinter.printLine();

	}
	
	//Method Overloading - Polymorphism
	public static void printLine() {
		System.out.println("------------------------------");
	}
	public static void printLine(int numberOfCharacters) {
		for (int i = 0; i < numberOfCharacters; i++) {
			System.out.print("-");			
		}
		System.out.println();
	}
	public static void printLine(int numberOfCharacters,char characters) {
		for (int i = 0; i < numberOfCharacters; i++) {
			System.out.print(characters);			
		}
		System.out.println();
	}

}
