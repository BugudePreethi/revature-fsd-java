package com.revature.app.fileio;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReadDemo {

	public static void main(String[] args) throws FileNotFoundException, IOException{
		FileReader reader = new FileReader("D:\\file.txt");
		FileWriter writer = new FileWriter("D:\\file-copy.txt");
		int character = reader.read();
		
		while(character != -1) {
			
			System.out.print((char) character);
			writer.write(character);
			character = reader.read();
		}
		writer.write("def");//We can add text either string or character
		writer.write('1');//We can also add numbers
		reader.close();
		writer.close();
		
	}

}
