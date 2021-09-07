package com.revature.app.task0609;

public class Task3Class {
	
	public static void main(String[] args) {
		
		Task3 <Integer> sum = (num1, num2) -> (num1 + num2);
	int a = sum.accept(2, 4);
	System.out.println(a);
		
	}
	
}
