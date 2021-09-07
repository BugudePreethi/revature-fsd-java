package com.revature.app.threads;

import java.util.List;
import java.util.Vector;

public class ThreadDemo extends Thread{
	//ArrayList is not thread safe
	//Vector is thread safe
	public static List<String> threads = new Vector<>();
	
	public void run() {
		threads.add(getName());
		System.out.println("Thread " + getName() + " is running...");
	}
}
