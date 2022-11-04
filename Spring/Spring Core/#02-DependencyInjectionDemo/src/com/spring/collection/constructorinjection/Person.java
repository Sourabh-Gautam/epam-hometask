package com.spring.collection.constructorinjection;

import java.util.ArrayList;

public class Person {
	
	private ArrayList<String> friends;

	public Person(ArrayList<String> friends) {
		this.friends = friends;
	}
	
	public ArrayList<String> getFriends() {
		return friends;
	}
	
}

