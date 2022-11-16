package com.epam.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.epam.entity.User;
	
@SpringBootTest
class UserRepositoryTest {
	
	@Autowired
	private UserRepository userRepository;
	
	@Test
	void findByUsernameTest() {
		User dbUser = userRepository.findByUsername("admin");
		assertNotNull(dbUser);
	}
	
}
