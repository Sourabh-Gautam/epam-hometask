package com.epam.quizapp.client;

import com.epam.quizapp.ui.LoginPage;
import com.epam.quizapp.ui.RegisterPage;
import com.epam.quizapp.util.Renderer;
import com.epam.quizapp.util.ScannerUtility;

public class OnlineQuiz {

	public static void main(String[] args) {
		
		System.out.println("\nRegister/Login page !\n");
		System.out.println("Press 1 - Register");
		System.out.println("Press 2 - Login");
		System.out.println("Press 3 - Exit");
		
		try {
			
			int choice = ScannerUtility.openScanner().nextInt();
			
			if(choice == 1) {
				System.out.println("Great !");
				Renderer.render(RegisterPage.class);
			}
			else if(choice == 2) {
				System.out.println("Great !");
				Renderer.render(LoginPage.class);
			}
			else if(choice == 3) {
				System.out.println("Bye !");
				return;
			}
			else {
				System.out.println("Try again. Please choose out of given options !");
			}
		}
		catch(Exception exception) {
			System.out.println("Try again. Please choose out of given options !");
		}
		finally {
			ScannerUtility.closeScanner();
		}
		
	}

}
