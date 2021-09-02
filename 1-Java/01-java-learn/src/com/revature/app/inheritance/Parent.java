package com.revature.app.inheritance;

public class Parent {
	
	//Protected
	protected int age;
	
	public Parent(int age) {
		System.out.println("Parent Constructor");
		this.age = age;
	}
	
	public void instanceMethod() {
		System.out.println("Parent instanceMethod()");
	}

}
