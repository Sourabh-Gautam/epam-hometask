package com.epam.quizapp.ui;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.quizapp.annotation.Render;
import com.epam.quizapp.client.OnlineQuiz;
import com.epam.quizapp.dao.UserDao;
import com.epam.quizapp.model.User;
import com.epam.quizapp.service.LoginService;
import com.epam.quizapp.util.Renderer;
import com.epam.quizapp.util.Request;
import com.epam.quizapp.util.RequestData;
import com.epam.quizapp.util.Response;
import com.epam.quizapp.util.ScannerUtility;

public class LoginPage {
	
	private static final Logger LOGGER = LogManager.getLogger(LoginPage.class);
	
	@Render
	public void processLoginPage() {
		LOGGER.info("Now enter your Admin/Student credentails.");
		LOGGER.info("Username : ");
		String username = ScannerUtility.openScanner().next();
		LOGGER.info("Password : ");
		String password = ScannerUtility.openScanner().next();
		
		RequestData<String, String> requestData = RequestData.getInstance();
		requestData.setAttribute("username", username);
		requestData.setAttribute("password", password);
		
		Request<String, User> request = Request.getInstance();
		Response<String, User> response = request.send(requestData, new LoginService(UserDao.getInstance()));

		if(response.getResponseData().getAttribute("userData")!=null) {
			LOGGER.info("Congratulations ! You have successfully Logged in.");
			User user = response.getResponseData().getAttribute("userData");
			
			if(user.getRole().equals("admin")) {
				Renderer.render(AdminPage.class);
			}
			else {
				LOGGER.info("Welcome to Student Page !");
				Renderer.render(StudentPage.class);
			}
			
		}
		else {
			LOGGER.info("Sorry, you have to register first.");
			LOGGER.info("Do you want to continue ? (y/n)");
			if(ScannerUtility.openScanner().next().equalsIgnoreCase("y")) {
				OnlineQuiz.main(null);
			}
		}
	}
	
	public static LoginPage getInstance() {
		return new LoginPage();
	}
	
}
