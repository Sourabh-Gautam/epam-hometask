package com.epam.quizapp.database;

import java.util.ArrayList;
import java.util.List;

import com.epam.quizapp.model.User;

public class UserCollection {
	
	private static List<User> userList = new ArrayList<>();
	
	static{
		String adminCredentials = "admin";
		String studentCredentials = "student";
		userList.add(new User(adminCredentials, adminCredentials, adminCredentials));
		userList.add(new User(studentCredentials, studentCredentials, studentCredentials));
	}
	
	public void insert(User user) {
		userList.add(user);
	}

	public List<User> getUserList() {
		return userList;
	}
	
	public User getUser(User user) {
		
		return userList.stream().filter(e -> e.equals(user)).findFirst().orElse(null);
		
	}
	
	public static UserCollection getInstance() {
		return new UserCollection();
	}
	
}
