package com.hashcode;

import java.util.Arrays;
import java.util.List;

public class Driver {

	public static void main(String[] args) {
		
		MyClass obj1 = new MyClass("Rahul");
		MyClass obj2 = new MyClass("Rahul");
		MyClass obj3 = new MyClass("Rahul");
		MyClass obj4 = new MyClass("Rahul");
		MyClass obj5 = new MyClass("Rahul");
		
		List<MyClass> list = Arrays.asList(obj1, obj2, obj3, obj4, obj5);
		
		for(MyClass obj : list) {
			System.out.println(obj);
		}
		
		System.out.println();
		System.out.println(obj1.equals(obj2));
	}

}
