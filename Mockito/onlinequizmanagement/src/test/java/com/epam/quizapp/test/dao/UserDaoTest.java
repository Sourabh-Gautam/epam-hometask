package com.epam.quizapp.test.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.epam.quizapp.dao.UserDao;
import com.epam.quizapp.model.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

@ExtendWith(value = { MockitoExtension.class })
public class UserDaoTest {

	@InjectMocks
	UserDao userDao;
	
	@Mock
	EntityManager entityManager;
	
	@Mock
	EntityManagerFactory entityManagerFactory;
	
	@Mock
	TypedQuery<User> typedQuery;
	
	@Mock
	EntityTransaction entityTransaction;
	
	User user;
	
	List<User> userList;
	
	@BeforeEach
	void setUp() {
		user = new User();
		user.setUsername("student");
		user.setPassword("student");
		userList = List.of(user);
	}
	
	@Test
	void registerUserTest() {
		
		when(entityManagerFactory.createEntityManager()).thenReturn(entityManager);
		when(entityManager.getTransaction()).thenReturn(entityTransaction);
		when(entityManager.createQuery("from User u where u.username = :username and u.password = :password", User.class)).thenReturn(typedQuery);
		when(typedQuery.getResultList()).thenReturn(userList);
		boolean result = userDao.registerUser(user);
		
		assertEquals(true, result);
		
	}
	
	@Test
	void getUserTest() {
		
		when(entityManagerFactory.createEntityManager()).thenReturn(entityManager);
		when(entityManager.createQuery("from User u where u.username = :username and u.password = :password", User.class)).thenReturn(typedQuery);
		when(typedQuery.getResultList()).thenReturn(userList);
		User result = userDao.getUser(user);
		
		assertNotNull(result);
		
	}
	
	@Test
	void getInstanceTest() {
		assertNotNull(UserDao.getInstance());
	}
	
}
