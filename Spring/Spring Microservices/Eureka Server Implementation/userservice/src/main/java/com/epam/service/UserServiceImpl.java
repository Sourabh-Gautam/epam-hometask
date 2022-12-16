package com.epam.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.epam.entity.User;
import com.epam.repo.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User addUser(User user) {

		return userRepository.save(user);
	}

	@Override
	public Optional<User> getUserByUserId(long userId) {
		return userRepository.findById(userId);
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public void deleteBookByUserId(long userId) {
		userRepository.deleteById(userId);		
	}

	@Override
	public User updateUserByUserId(User userDb) {
		return userRepository.save(userDb);
	}



}
