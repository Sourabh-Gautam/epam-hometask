package com.epam.quizapp.test.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.epam.quizapp.model.User;
import com.epam.quizapp.service.RegisterService;
import com.epam.quizapp.service.Service;
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
		
		Service<String, User> service = mock(Service.class);
		
		User user = new User();
		user.setUsername("epam");
		user.setPassword("epam");
		user.setRole("student");
		ResponseData<String, User> mockitoResponseData = ResponseData.getInstance();
		mockitoResponseData.setAttribute("data", user);
		Response<String, User> mockitoResponse = Response.getInstance();
		mockitoResponse.setResponseData(mockitoResponseData);
		
		requestData.setAttribute("username", "epam");
		requestData.setAttribute("password", "epam");		
		
		when(service.init(requestData)).thenReturn(mockitoResponse);
		
		Response<String, User> response = service.init(requestData);
		ResponseData<String, User> responseData = response.getResponseData();
		
		User existingUser = responseData.getAttribute("data");
		
		assertEquals(user, existingUser);
	}
	
	@Test
	void studentAlreadyRegisterTest() {
		requestData.setAttribute("username", "student");
		requestData.setAttribute("password", "student");
		Service<String, User> service = new RegisterService();
		
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
