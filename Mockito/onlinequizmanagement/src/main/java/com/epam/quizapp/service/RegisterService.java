package com.epam.quizapp.service;

import com.epam.quizapp.dao.UserDao;
import com.epam.quizapp.model.User;
import com.epam.quizapp.util.RequestData;
import com.epam.quizapp.util.Response;
import com.epam.quizapp.util.ResponseData;

public class RegisterService implements Service<String, Boolean> {
	
	UserDao userDao;
	
	public RegisterService(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public Response<String, Boolean> init(RequestData<String, String> requestData) {
		
		User user = new User();
		
		user.setUsername(requestData.getAttribute("username"));
		user.setPassword(requestData.getAttribute("password"));
		
		boolean isRegistered = userDao.registerUser(user);
		ResponseData<String, Boolean> responseData = ResponseData.getInstance();
		responseData.setAttribute("userData", isRegistered);
		Response<String, Boolean> response = Response.getInstance();
		response.setResponseData(responseData);
		
		return response;
		
	}
	
}
