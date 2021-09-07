package com.revature.app.string;

public class MutableStringDemo {

	public static void main(String[] args) {
		//We know that string is immutable
		//To overcome that we have StringBuffer and StringBuilder which are mutable
		//Here StringBuffer is thread safe
		//Here StringBuilder is not thread safe
		System.out.println("Using StringBuffer");
		StringBuffer buffer = new StringBuffer("Hello");
		System.out.println(buffer);
		buffer.reverse();
		System.out.println(buffer);
		
		System.out.println("Using StringBuilder");
		StringBuilder builder = new StringBuilder("Hello");
		System.out.println(builder);
		builder.reverse();
		System.out.println(builder);
	}

}
