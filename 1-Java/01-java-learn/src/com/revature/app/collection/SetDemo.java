package com.revature.app.collection;

import java.util.HashSet;
import java.util.Set;

public class SetDemo {
	
	public static void main(String[] args) {
		Person person1 = new Person("John", 15);
		Person person2 = new Person("Smith", 25);
		Person person3 = new Person("Stella", 32);
		Person person4 = new Person("Maria", 42);
		Person person5 = new Person("Mark", 13);
		Person person6 = new Person("Maria", 42);
		
		Set<Person> personSet = new HashSet<>();
		personSet.add(person1);
		personSet.add(person2);
		personSet.add(person3);
		personSet.add(person4);
		personSet.add(person5);
		personSet.add(person6);
		
		for (Person person : personSet) {
			System.out.println(person);
		}
	}

}
