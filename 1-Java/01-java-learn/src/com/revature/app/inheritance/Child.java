package com.revature.app.inheritance;

public class Child extends Parent {
	
	public Child(int age) {
		super(age);
	}
	
	public void childInstanceMethod() {
		super.instanceMethod();
		System.out.println("childInstanceMethod()");
		System.out.println(age);
	}
	
	// Method Overriding
	public void instanceMethod() {
		//super.instanceMethod();
		System.out.println("Child instanceMethod()");
	}
	
	public static void main(String[] args) {
		Child child = new Child(10);
		//child.childInstanceMethod();
		
		// Runtime Polymorphism
		Parent parent = new Child(20);
		parent.instanceMethod();
	}

}
