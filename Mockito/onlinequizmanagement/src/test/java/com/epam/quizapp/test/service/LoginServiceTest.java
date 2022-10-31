package com.epam.quizapp.test.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.epam.quizapp.dao.UserDao;
import com.epam.quizapp.model.User;
import com.epam.quizapp.service.LoginService;
import com.epam.quizapp.util.RequestData;
import com.epam.quizapp.util.Response;
import com.epam.quizapp.util.ResponseData;

@ExtendWith(value = { MockitoExtension.class })
class LoginServiceTest {
	
	@Mock
	private UserDao userDao;
	
	private User user;
	private RequestData<String, String> requestData;
	
	@BeforeEach
	void setUp() {
		user = new User();
		requestData = RequestData.getInstance();
	}
	
	@Test
	void adminLoginTest() {
		
		user.setUsername("admin");
		user.setPassword("admin");
		user.setRole("admin");
		when(userDao.getUser(user)).thenReturn(user);
		
		requestData.setAttribute("username", "admin");
		requestData.setAttribute("password", "admin");
		
		Response<String, User> response = new LoginService(userDao).init(requestData);
		ResponseData<String, User> responseData = response.getResponseData();
		
		User existingUser = responseData.getAttribute("userData");
		
		assertEquals(user, existingUser);
	} 
	
	@Test
	void exitingStudentLoginTest() {
		user.setUsername("student");
		user.setPassword("student");
		user.setRole("student");
		when(userDao.getUser(user)).thenReturn(user);
		
		requestData.setAttribute("username", "student");
		requestData.setAttribute("password", "student");
		
		Response<String, User> response = new LoginService(userDao).init(requestData);
		ResponseData<String, User> responseData = response.getResponseData();
		
		User existingUser = responseData.getAttribute("userData");
		
		assertEquals(user, existingUser);
	}
	
	@Test
	void notExistingStudentLoginTest() {
		user.setUsername("sourabh");
		user.setPassword("sourabh");
		user.setRole("student");
		when(userDao.getUser(user)).thenReturn(null);
		
		requestData.setAttribute("username", "sourabh");
		requestData.setAttribute("password", "sourabh");
		
		Response<String, User> response = new LoginService(userDao).init(requestData);
		ResponseData<String, User> responseData = response.getResponseData();
		
		User existingUser = responseData.getAttribute("userData");
		
		assertEquals(null, existingUser);
	} 


}
