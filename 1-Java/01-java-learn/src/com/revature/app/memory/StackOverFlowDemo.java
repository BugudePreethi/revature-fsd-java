package com.revature.app.memory;

public class StackOverFlowDemo {
	
	public static void main(String[] args) {
		recursiveFunction();
	}
	
	public static void recursiveFunction() {
		recursiveFunction();
	}

}
