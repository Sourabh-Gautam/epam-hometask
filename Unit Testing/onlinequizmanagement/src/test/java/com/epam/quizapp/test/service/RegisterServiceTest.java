package com.epam.quizapp.test.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.epam.quizapp.model.User;
import com.epam.quizapp.service.RegisterService;
import com.epam.quizapp.util.RequestData;
import com.epam.quizapp.util.Response;
import com.epam.quizapp.util.ResponseData;

class RegisterServiceTest {
	
	RequestData<String, String> requestData;
	
	@BeforeEach
	void supplyRequestDataObj() {
		requestData = RequestData.getInstance();
	}
	
	@Test
	void newStudentRegisterTest() {
		requestData.setAttribute("username", "epam");
		requestData.setAttribute("password", "epam");
		
		Response<String, User> response = new RegisterService().init(requestData);
		ResponseData<String, User> responseData = response.getResponseData();
		
		User existingUser = responseData.getAttribute("userData");
		User user = new User();
		user.setUsername("epam");
		user.setPassword("epam");
		user.setRole("student");
		
		assertEquals(user, existingUser);
	}
	
	@Test
	void studentAlreadyRegisterTest() {
		requestData.setAttribute("username", "student");
		requestData.setAttribute("password", "student");
		
		Response<String, User> response = new RegisterService().init(requestData);
		ResponseData<String, User> responseData = response.getResponseData();
		
		User existingUser = responseData.getAttribute("userData");
		
		assertEquals(null, existingUser);
	}
	
	@Test
	void credentialsMatchAdminTest() {
		requestData.setAttribute("username", "admin");
		requestData.setAttribute("password", "admin");
		
		Response<String, User> response = new RegisterService().init(requestData);
		ResponseData<String, User> responseData = response.getResponseData();
		
		User existingUser = responseData.getAttribute("userData");
		
		assertEquals(null, existingUser);
	}

}
