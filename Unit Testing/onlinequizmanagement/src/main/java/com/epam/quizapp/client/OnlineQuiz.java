package com.epam.quizapp.client;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.quizapp.ui.LoginPage;
import com.epam.quizapp.ui.RegisterPage;
import com.epam.quizapp.util.Renderer;
import com.epam.quizapp.util.ScannerUtility;

public class OnlineQuiz {
	
	private static final Logger LOGGER = LogManager.getLogger(OnlineQuiz.class);

	public static void main(String[] args) {
	
		LOGGER.info("Register/Login page !");
		LOGGER.info("Press 1 - Register");
		LOGGER.info("Press 2 - Login");
		LOGGER.info("Press 3 - Exit");
		
		try {
			
			int choice = ScannerUtility.openScanner().nextInt();
			
			if(choice == 1) {
				LOGGER.info("Great !");
				Renderer.render(RegisterPage.class);
			}
			else if(choice == 2) {
				LOGGER.info("Great !");
				Renderer.render(LoginPage.class);
			}
			else if(choice == 3) {
				LOGGER.info("Bye !");
			}
			else {
				LOGGER.info("Try again. Please choose out of given options !");
			}
		}
		catch(Exception exception) {
			LOGGER.error("Try again. Please choose out of given options !");
		}
		finally {
			ScannerUtility.closeScanner();
		}
		
	}

}
