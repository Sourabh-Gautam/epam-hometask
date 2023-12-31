package com.epam.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.epam.entity.User;
import com.epam.repository.UserRepository;

@SpringBootTest
public class UserServiceTest {
	
	@MockBean
	private UserRepository userRepository;
	
	@Autowired
	private UserService userService;
	
	private User user;
	
	@BeforeEach
	void setUp() throws Exception {
		user = User.builder()
				.username("epam")
				.password("epam")
				.role("student")
				.build();
	}
	
	@Test
	void registerUserServiceTest() {
		
		when(userRepository.save(user)).thenReturn(user);
		User userdb = userService.register(user);
		assertEquals("epam", userdb.getUsername());
	}
	
	@Test
	void getUserByUsernameTest() {
		when(userRepository.findByUsername("epam")).thenReturn(user);
		User userdb = userService.getUserByUsername("epam");
		assertEquals("epam", userdb.getUsername());
	}
}
