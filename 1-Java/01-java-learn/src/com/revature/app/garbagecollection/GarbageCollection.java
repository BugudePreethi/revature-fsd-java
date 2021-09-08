package com.revature.app.garbagecollection;

public class GarbageCollection {

	public static void main(String[] args) {
		Person person = new Person("John", 15);
		person = null;
		
		Person person1 = new Person("John", 15);
		Person person2 = new Person("Smith", 25);
		person1 = person2;
		
		for(int i = 0; i < 10; i++) {
			Person person3 = new Person("Stella", 32);
		}
		System.gc();
	}

}
