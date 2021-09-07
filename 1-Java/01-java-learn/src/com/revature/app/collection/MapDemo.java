package com.revature.app.collection;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {

	public static void main(String[] args) {
		Person person1 = new Person(1, "John", 15);
		Person person2 = new Person(2, "Smith", 25);
		Person person3 = new Person(3, "Stella", 32);
		Person person4 = new Person(4, "Maria", 42);
		Person person5 = new Person(5, "Maria", 42);
		Person person6 = new Person(4, "Mark", 42);
		
		Map<Long, Person> personMap = new HashMap<>();
		personMap.put(person1.getId(), person1);
		personMap.put(person2.getId(), person2);
		personMap.put(person3.getId(), person3);
		personMap.put(person4.getId(), person4);
		personMap.put(person5.getId(), person5);
		personMap.put(person6.getId(), person6);
		
		for (Long id : personMap.keySet()) {
			System.out.println("Person: " + personMap.get(id));
		}
		
		personMap.remove(1L);
		System.out.println("\nMap after deletion:");
		for (Long id : personMap.keySet()) {
			System.out.println("Person: " + personMap.get(id));
		}

	}

}
