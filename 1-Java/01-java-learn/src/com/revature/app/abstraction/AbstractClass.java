package com.revature.app.abstraction;

public abstract class AbstractClass {
	private int age;
	
	public AbstractClass(int age) {
		super();
		this.age = age;
	}
	
	public abstract void abstractMethod();
	
	public void instanceMethod() {
		System.out.println("Abstrct class instanceMethod()");
	}

}
