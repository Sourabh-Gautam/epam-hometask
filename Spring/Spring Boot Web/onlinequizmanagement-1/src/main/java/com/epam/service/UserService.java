package com.epam.service;

import com.epam.entity.User;
import com.epam.repository.UserRepository;

@org.springframework.stereotype.Service
public class UserService {
	
	UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public User register(User user) {
		return userRepository.save(user);
	}

	public User getUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	
}
