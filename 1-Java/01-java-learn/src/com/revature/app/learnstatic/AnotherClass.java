package com.revature.app.learnstatic;

public class AnotherClass {

	public static void main(String[] args) {
		System.out.println(StaticDemo.age);
		StaticDemo.age = 25;
		System.out.println(StaticDemo.age);
		
		StaticDemo staticDemo1 = new StaticDemo();
		System.out.println(staticDemo1.age);
		staticDemo1.age = 35;
		
		System.out.println(StaticDemo.age);
		System.out.println(staticDemo1.age);
	}

}
