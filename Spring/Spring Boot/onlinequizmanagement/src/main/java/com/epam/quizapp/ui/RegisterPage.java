package com.epam.quizapp.ui;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.epam.quizapp.client.OnlineQuiz;
import com.epam.quizapp.service.RegisterService;
import com.epam.quizapp.util.Request;
import com.epam.quizapp.util.RequestData;
import com.epam.quizapp.util.Response;
import com.epam.quizapp.util.ScannerUtility;

@Component
public class RegisterPage implements Page, ApplicationContextAware {
	
	ApplicationContext applicationContext;
	
	private static final Logger LOGGER = LogManager.getLogger(RegisterPage.class);
	
	public void view() {
				
		LOGGER.info("Provides the below details.");
		LOGGER.info("Username : ");
		String username = ScannerUtility.openScanner().next();
		LOGGER.info("Password : ");
		String password = ScannerUtility.openScanner().next();
		
		RequestData<String, String> requestData = RequestData.getInstance();
		requestData.setAttribute("username", username);
		requestData.setAttribute("password", password);
		
		Request<String, Boolean> request = Request.getInstance();
		Response<String, Boolean> response = request.send(requestData, applicationContext.getBean(RegisterService.class));
		
		if(Boolean.TRUE.equals(response.getResponseData().getAttribute("userData"))) {
			LOGGER.info("Congratulations ! You have successfully Registered.");
		}
		else {
			LOGGER.info("Sorry, you are already registered.");
		}
		LOGGER.info("Do you want to continue ? (y/n)");
		if(ScannerUtility.openScanner().next().equalsIgnoreCase("y")) {
			OnlineQuiz.main(null);
		}
		
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
	
}
