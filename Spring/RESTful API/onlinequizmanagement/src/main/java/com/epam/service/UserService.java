package com.epam.service;

import java.util.Optional;

import com.epam.entity.User;
import com.epam.exception.ResourceNotFoundException;
import com.epam.repo.UserRepository;

@org.springframework.stereotype.Service
public class UserService {
	
	UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public User register(User user) throws ResourceNotFoundException {
		Optional<User> dbUser = getUserByUsername(user.getUsername());
		
		if(dbUser.isPresent()) {
			throw new ResourceNotFoundException("Username already exists");
		}
		System.out.println(user);
		return userRepository.save(user);
	}

	public Optional<User> getUserByUsername(String username) {
		return Optional.ofNullable(userRepository.findByUsername(username));
	}
	
}
