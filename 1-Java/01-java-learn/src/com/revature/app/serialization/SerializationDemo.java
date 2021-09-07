package com.revature.app.serialization;

//import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class SerializationDemo {

	public static void main(String[] args) throws IOException {
		//Serialization : Conversion of an object to bytes which can be helpful in transfering it into file or to network
		Person person1 = new Person("John", 15);
		Person person2 = new Person("Smith", 25);
		Person person3 = new Person("Stella", 32);
		Person person4 = new Person("Maria", 42);
		Person person5 = new Person("Maria", 42);
		Person person6 = new Person("Mark", 13);
		
		List<Person> personList= new ArrayList<>();
		personList.add(person1);
		personList.add(person2);
		personList.add(person3);
		personList.add(person4);
		personList.add(person5);
		personList.add(person6);
		
		FileOutputStream fileOutputStream = new FileOutputStream("D:\\persons.ser");
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
		
		//fileObjectStream can write only byte code hence we use objectOutputStream
		objectOutputStream.writeObject(personList);//A byte code is created in the file named persons.ser
		
		objectOutputStream.close();
		fileOutputStream.close();		
	}

}
