package com.revature.app.task0609;

public class Person implements Comparable<Person> {
	private long id;
	private String name;
	private int age;
	
	public Person(String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		System.out.println("Person.equals() called");
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public int compareTo(Person person) {
		//Person otherPerson = (Person) o;
		System.out.println(this.name + " " + person.name + " " + name.compareTo(person.name));
		return name.compareTo(person.name); // +ve - First object comes first; -ve - 2nd Object First; 0 - Equal
		//return age - person.age;
	}

}

