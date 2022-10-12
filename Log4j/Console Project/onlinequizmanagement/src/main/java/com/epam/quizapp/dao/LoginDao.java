package com.epam.quizapp.dao;

import com.epam.quizapp.database.UserCollection;
import com.epam.quizapp.model.User;

public class LoginDao {
	
	public static User getUser(User user) {
		
		UserCollection userCollection = UserCollection.getInstance();
		return userCollection.getUser(user);
	
	}
	
}
