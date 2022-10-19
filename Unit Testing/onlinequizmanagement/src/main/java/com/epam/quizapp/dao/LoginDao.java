package com.epam.quizapp.dao;

import com.epam.quizapp.database.UserCollection;
import com.epam.quizapp.model.User;

public class LoginDao {
	
	private LoginDao() {
		
	}
	
	public static User getUser(User user) {
		
		return UserCollection.getInstance().getUser(user);
	
	}
	
}
