package com.epam.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import com.epam.entity.User;
	
@SpringBootTest
class QuizRepositoryTest {
	
	@Autowired
	private UserRepository userRepository;
	
	private User user;
	
	@BeforeEach
	void setUp() {
		user = User.builder()
				.username("admin")
				.password("admin")
				.role("admin")
				.build();
	}
	
	@Test
	void registerStudentTest() {
		User dbUser = userRepository.save(user);
		assertThat(dbUser.getUsername()).isNotBlank();
	}
	
	@Test
	void findByUsernameTest() {
		User dbUser = userRepository.findByUsername("admin");
		assertNotNull(dbUser);
	}
	
}
