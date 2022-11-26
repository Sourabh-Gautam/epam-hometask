package com.epam.service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.epam.entity.User;
import com.epam.exception.ResourceNotFoundException;
import com.epam.repo.UserRepository;

@org.springframework.stereotype.Service
public class UserService implements UserDetailsService {
	
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
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		if (null == user) {
			throw new UsernameNotFoundException("Cannot find username :" + username);
		}
		org.springframework.security.core.userdetails.User userDetails = new org.springframework.security.core.userdetails.User(
				user.getUsername(), user.getPassword(), Collections.emptyList());
		return userDetails;
	}

	public Optional<User> getUserByUsername(String username) {
		return Optional.ofNullable(userRepository.findByUsername(username));
	}
	
}
