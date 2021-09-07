package com.revature.app.fileio;

import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class StreamDemo {
	
	//We can read images, videos and large amount of text using FileInputStream and FileOutputStream

	public static void main(String[] args) throws FileNotFoundException, IOException{
		FileInputStream reader = new FileInputStream("D:\\google.png");
		FileOutputStream writer = new FileOutputStream("D:\\google-copy.png");
		int character = reader.read();
		
		while(character != -1) {
			
			System.out.print((char) character);
			writer.write(character);
			character = reader.read();
		}
	
		reader.close();
		writer.close();
		
	}

}
