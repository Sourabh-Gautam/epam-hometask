package com.epam.quizapp.ui;

import com.epam.quizapp.annotation.Render;
import com.epam.quizapp.client.OnlineQuiz;
import com.epam.quizapp.model.User;
import com.epam.quizapp.service.LoginService;
import com.epam.quizapp.util.Renderer;
import com.epam.quizapp.util.Request;
import com.epam.quizapp.util.RequestData;
import com.epam.quizapp.util.Response;
import com.epam.quizapp.util.ScannerUtility;

public class LoginPage {
	
	@Render
	public void processLoginPage() {
		System.out.println("\nNow enter your Admin/Student credentails.");
		System.out.print("Username : ");
		String username = ScannerUtility.openScanner().next();
		System.out.print("Password : ");
		String password = ScannerUtility.openScanner().next();
		
		RequestData<String, String> requestData = RequestData.getInstance();
		requestData.setAttribute("username", username);
		requestData.setAttribute("password", password);
		
		Request<String, User> request = Request.getInstance();
		Response<String, User> response = request.send(requestData, new LoginService());

		if(response.getResponseData().getAttribute("userData")!=null) {
			System.out.println("Congratulations ! You have successfully Logged in.");
			User user = (User)response.getResponseData().getAttribute("userData");
			
			if(user.getRole().equals("admin")) {
				Renderer.render(AdminPage.class);
			}
			else {
				System.out.println("\nWelcome to Student Page !");
				Renderer.render(StudentPage.class);
			}
			
		}
		else {
			System.out.println("Sorry, you have to register first.");
			System.out.println("Do you want to continue ? (y/n)");
			if(ScannerUtility.openScanner().next().toLowerCase().equals("y")) {
				OnlineQuiz.main(null);
			}
		}
		return;
	}
	
	public static LoginPage getInstance() {
		return new LoginPage();
	}
	
}
