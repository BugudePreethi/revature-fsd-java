package com.revature.app.collection;

import java.util.Stack;

public class StackDemo {
	
	public static void main(String[] args) {
		Person person1 = new Person("John", 15);
		Person person2 = new Person("Smith", 25);
		Person person3 = new Person("Stella", 32);
		Person person4 = new Person("Maria", 42);
		Person person5 = new Person("Mark", 13);
		Person person6 = new Person("Maria", 42);
		
		Stack<Person> personStack = new Stack<>();
		personStack.add(person1);
		personStack.add(person2);
		personStack.add(person3);
		personStack.add(person4);
		personStack.add(person5);
		personStack.add(person6);
		
		for (Person person : personStack) {
			System.out.println(person);
		}
		
		Person person = personStack.pop();
		System.out.println("Person poped : " + person);
		
		for(Person person11 : personStack) {
			System.out.println(person11);
		}
		
	}
}
