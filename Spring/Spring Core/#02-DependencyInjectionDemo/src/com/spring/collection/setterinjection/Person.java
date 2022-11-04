package com.spring.collection.setterinjection;

import java.util.ArrayList;

public class Person {
	
	private ArrayList<String> friends;

	public ArrayList<String> getFriends() {
		return friends;
	}

	public void setFriends(ArrayList<String> friends) {
		this.friends = friends;
	}
	
}

