package com.epam.quizapp.dao;

import java.util.Optional;

import com.epam.quizapp.database.UserCollection;
import com.epam.quizapp.model.User;

public class RegisterDao {
	
	private RegisterDao() {
	}
	
	public static Optional<User> registerUser(User user) {
		
		Optional<User> userOptional = Optional.empty();
		if(LoginDao.getUser(user)==null) {
			UserCollection.getInstance().insert(user);
			userOptional = Optional.ofNullable(user);
		}
		return userOptional;
	}
}
