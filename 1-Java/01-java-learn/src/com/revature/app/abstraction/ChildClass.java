package com.revature.app.abstraction;

public class ChildClass extends AbstractClass{
	
	public ChildClass(int age) {
			super(age);
	}
	
	@Override
	public void abstractMethod() {
		System.out.println("Concrete abstratMMethod(in child class");
	}
	
	public static void main(String[] args) {
		ChildClass childClass = new ChildClass(10);
		childClass.abstractMethod();
	}
}

