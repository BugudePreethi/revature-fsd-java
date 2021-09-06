package com.revature.app.collection;

import java.util.ArrayList;
import java.util.Collections;

public class ListDemo {

	public static void main(String[] args) {
		//Integer age = new Integer(10);
		Integer age = 10;//auto boxing
		
		ArrayList<Integer> arrayList = new ArrayList<>();
		arrayList.add(78);
		arrayList.add(37);
		arrayList.add(54);
		arrayList.add(80);
		arrayList.add(29);
		arrayList.add(62);
		
		for (Integer number : arrayList) {
			System.out.println(number);
		}
		
		System.out.println("\nUsing Index");
		for (int i = 0; i <arrayList.size(); i++) {
			System.out.println(arrayList.get(i));
		}
		
		System.out.println("\nSorting");
		Collections.sort(arrayList);
		for (Integer number : arrayList) {
			System.out.println(number);
		}
	}

}