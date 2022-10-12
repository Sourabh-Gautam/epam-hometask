package com.epam.quizapp.ui;

import com.epam.quizapp.annotation.Render;
import com.epam.quizapp.client.OnlineQuiz;
import com.epam.quizapp.model.User;
import com.epam.quizapp.service.RegisterService;
import com.epam.quizapp.util.Request;
import com.epam.quizapp.util.RequestData;
import com.epam.quizapp.util.Response;
import com.epam.quizapp.util.ScannerUtility;

public class RegisterPage {
	
	@Render
	public void procesRegisterPage() {
		
		System.out.println("\nProvides the below details.\n");
		System.out.print("Username : ");
		String username = ScannerUtility.openScanner().next();
		System.out.print("Password : ");
		String password = ScannerUtility.openScanner().next();
		
		RequestData<String, String> requestData = RequestData.getInstance();
		requestData.setAttribute("username", username);
		requestData.setAttribute("password", password);
		
		Request<String, User> request = Request.getInstance();
		Response<String, User> response = request.send(requestData, new RegisterService<String, User>());
		
		if(response.getResponseData().getAttribute("userData")!=null) {
			System.out.println("Congratulations ! You have successfully Registered.");
		}
		else {
			System.out.println("Sorry, you are already registered.");
		}
		System.out.println("Do you want to continue ? (y/n)");
		if(ScannerUtility.openScanner().next().toLowerCase().equals("y")) {
			OnlineQuiz.main(null);
		}
		return;
		
	}
	
	public static RegisterPage getInstance() {
		return new RegisterPage();
	}
	
}
