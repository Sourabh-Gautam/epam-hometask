package com.epam.quizapp.service;

import com.epam.quizapp.dao.LoginDao;
import com.epam.quizapp.model.User;
import com.epam.quizapp.util.RequestData;
import com.epam.quizapp.util.Response;
import com.epam.quizapp.util.ResponseData;

public class LoginService implements Service<String, User> {
	public Response<String, User> init(RequestData<String, String> requestData) {
		
		User user = new User();
		user.setUsername(requestData.getAttribute("username"));
		user.setPassword(requestData.getAttribute("password"));
		
		User existingUser = LoginDao.getUser(user);
		ResponseData<String, User> responseData = ResponseData.getInstance();
		responseData.setAttribute("userData", existingUser);
		
		Response<String, User> response = Response.getInstance();
		response.setResponseData(responseData);
		return response;
	}

}
