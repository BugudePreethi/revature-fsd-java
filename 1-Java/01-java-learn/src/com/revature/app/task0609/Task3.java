package com.revature.app.task0609;

//Create a functional interface for two parameters with return value.

@FunctionalInterface
public interface Task3<T> {
	int accept (T t1, T t2);	
}
