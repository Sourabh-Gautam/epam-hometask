package com.epam.quizapp.test.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.epam.quizapp.model.User;
import com.epam.quizapp.service.LoginService;
import com.epam.quizapp.util.RequestData;
import com.epam.quizapp.util.Response;
import com.epam.quizapp.util.ResponseData;

class LoginServiceTest {
	
	RequestData<String, String> requestData;
	
	@BeforeEach
	void supplyRequestDataObj() {
		requestData = RequestData.getInstance();
	}
	
	@Test
	void adminLoginTest() {
		requestData.setAttribute("username", "admin");
		requestData.setAttribute("password", "admin");
		
		Response<String, User> response = new LoginService().init(requestData);
		ResponseData<String, User> responseData = response.getResponseData();
		
		User existingUser = responseData.getAttribute("userData");
		User user = new User();
		user.setUsername("admin");
		user.setPassword("admin");
		user.setRole("admin");
		
		assertEquals(user, existingUser);
	} 
	
	@Test
	void exitingStudentLoginTest() {
		requestData.setAttribute("username", "student");
		requestData.setAttribute("password", "student");
		
		Response<String, User> response = new LoginService().init(requestData);
		ResponseData<String, User> responseData = response.getResponseData();
		
		User existingUser = responseData.getAttribute("userData");
		User user = new User();
		user.setUsername("student");
		user.setPassword("student");
		user.setRole("student");
		
		assertEquals(user, existingUser);
	}
	
	@Test
	void notExistingStudentLoginTest() {
		requestData.setAttribute("username", "epam");
		requestData.setAttribute("password", "epam");
		
		Response<String, User> response = new LoginService().init(requestData);
		ResponseData<String, User> responseData = response.getResponseData();
		
		User existingUser = responseData.getAttribute("userData");
		
		assertEquals(null, existingUser);
	} 


}
