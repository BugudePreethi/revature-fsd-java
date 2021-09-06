package com.revature.app.collection;

import java.util.LinkedList;
import java.util.List;

public class LinkedListDemo {

	public static void main(String[] args) {
		Person person1 = new Person("John", 15);
		Person person2 = new Person("Smith", 25);
		Person person3 = new Person("Stella", 32);
		Person person4 = new Person("Maria", 42);
		Person person5 = new Person("Maria", 42);
		Person person6 = new Person("Mark", 13);
		
		List<Person> personList= new LinkedList<>();
		personList.add(person1);
		personList.add(person2);
		personList.add(person3);
		personList.add(person4);
		personList.add(person5);
		personList.add(person6);
		
		personList.add(1, new Person("Janet", 25));
		
		for (Person person : personList) {
			System.out.println(person);
		}
	}

}
