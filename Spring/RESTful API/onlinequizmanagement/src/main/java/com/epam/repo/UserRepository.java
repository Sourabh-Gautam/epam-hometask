package com.epam.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.epam.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	public User findByUsername(String username);

}
