package com.revature.app.abstraction;

public class InterfaceImplementation implements Interface{
	@Override
	public void abstractMethod() {
		System.out.println("Interface implementation abstractMethod()");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Interface interface1 = new InterfaceImplementation();
		interface1.abstractMethod();
	}

}
