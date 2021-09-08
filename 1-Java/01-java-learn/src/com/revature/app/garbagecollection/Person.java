package com.revature.app.garbagecollection;

public class Person implements Comparable<Person> {
	private static long counter = 0;
	private long id;
	private String name;
	private int age;
	
	public Person(String name, int age) {
		super();
		counter++;
		this.id = counter;
		this.name = name;
		this.age = age;
		//System.out.println(toString());
	}
	
	public Person(long id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}	

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
		System.out.println(toString());
	}

	@Override
	public String toString() {
		return "Person [id= " + id +",name=" + name + ", age=" + age + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (age != other.age)
			return false;
		if (id != other.id)
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
		//System.out.println(this.name + " " + person.name + " " + name.compareTo(person.name));
		return 0; // +ve - First object comes first; -ve - 2nd Object First; 0 - Equal
		//return age - person.age;
	}

}
