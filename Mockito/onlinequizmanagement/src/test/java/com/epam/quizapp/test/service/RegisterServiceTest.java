package com.epam.quizapp.test.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.epam.quizapp.dao.UserDao;
import com.epam.quizapp.model.User;
import com.epam.quizapp.service.RegisterService;
import com.epam.quizapp.util.RequestData;
import com.epam.quizapp.util.Response;
import com.epam.quizapp.util.ResponseData;

@ExtendWith(value = { MockitoExtension.class })
class RegisterServiceTest {
	
	@Mock
	UserDao userDao;
	
	@Test
	void newStudentRegisterTest() {

		User user = new User();
		user.setUsername("epam");
		user.setPassword("epam");
		user.setRole("student");
		
		when(userDao.registerUser(user)).thenReturn(true);
		
		RequestData<String, String> requestData = RequestData.getInstance();
		requestData.setAttribute("username", "epam");
		requestData.setAttribute("password", "epam");
		
		Response<String, Boolean> mockitoResponse = new RegisterService(userDao).init(requestData);		
		ResponseData<String, Boolean> mockitoResponseData = mockitoResponse.getResponseData();
		boolean isRegistered = mockitoResponseData.getAttribute("userData");
		
		assertEquals(true, isRegistered);
	}

}
