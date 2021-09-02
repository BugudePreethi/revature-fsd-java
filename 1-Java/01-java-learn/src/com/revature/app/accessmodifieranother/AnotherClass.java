package com.revature.app.accessmodifieranother;

import com.revature.app.accesssmodifier.packageDemo;

public class AnotherClass {

	public static void main(String[] args) {
		packageDemo demo = new packageDemo();
		/* demo.age is not visible as it is from the another package
		System.out.println(demo.age); */
	}

}
