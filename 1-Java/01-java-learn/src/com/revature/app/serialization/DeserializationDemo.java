package com.revature.app.serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;


public class DeserializationDemo {

	public static void main(String[] args)  /*throws IOException, ClassNotFoundException*/{
		try {
			FileInputStream fileInputStream = new FileInputStream("D:\\persons.ser");
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
			
			List<Person> personList = (ArrayList) objectInputStream.readObject();
			
			personList.forEach(System.out::println);
			
			objectInputStream.close();
			fileInputStream.close();
		} catch (FileNotFoundException e) {
			
		} catch (IOException e) {
			
		} catch (ClassNotFoundException e) {
			
		}
	}
}
