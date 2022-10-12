package com.epam.quizapp.dao;

import com.epam.quizapp.database.UserCollection;
import com.epam.quizapp.model.User;

public class RegisterDao {
	public static User registerUser(User user) {
		
		if(LoginDao.getUser(user)==null) {
			UserCollection.getInstance().insert(user);
			return user;
		}
		else {
			return null;
		}
	}
}
