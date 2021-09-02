package com.revature.app.accesssmodifier;

public class AnotherClass {

	public static void main(String[] args) {
		packageDemo demo = new packageDemo();
		// demo.age is visible as it is from the same package
		System.out.println(demo.age);

	}

}
