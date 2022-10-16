package com.epam.quizapp.service;

import com.epam.quizapp.dao.RegisterDao;
import com.epam.quizapp.model.User;
import com.epam.quizapp.util.RequestData;
import com.epam.quizapp.util.Response;
import com.epam.quizapp.util.ResponseData;

public class RegisterService<T, E> implements Service<String, User> {
	
	public Response<String, User> init(RequestData<String, String> requestData) {
		
		User user = new User();
		user.setUsername(requestData.getAttribute("username"));
		user.setPassword(requestData.getAttribute("password"));
		
		User isRegistered = RegisterDao.registerUser(user);
		ResponseData<String, User> responseData = ResponseData.getInstance();
		responseData.setAttribute("userData", isRegistered);
		Response<String, User> response = Response.getInstance();
		response.setResponseData(responseData);
		
		return response;
		
	}
	
}
