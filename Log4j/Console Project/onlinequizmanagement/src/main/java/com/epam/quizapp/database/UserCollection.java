package com.epam.quizapp.database;

import java.util.ArrayList;
import java.util.List;

import com.epam.quizapp.model.User;

public class UserCollection {
	
	private static List<User> userList = new ArrayList<>();
	
	static{
		userList.add(new User("admin", "admin", "admin"));
		userList.add(new User("student", "student", "student"));
	}
	
	public void insert(User user) {
		userList.add(user);
	}

	public List<User> getUserList() {
		return userList;
	}
	
	public User getUser(User user) {
//		for(User existingUser : userList) {
//			if(user.equals(existingUser)) {
//				user = existingUser;
//			}
//		}
		
		return userList.stream().filter(e -> e.equals(user)).findFirst().orElse(null);
		
//		return user;
	}
	
	public static UserCollection getInstance() {
		return new UserCollection();
	}
	
}
