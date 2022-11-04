package com.epam.quizapp.client;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.epam.quizapp.ui.LoginPage;
import com.epam.quizapp.ui.RegisterPage;
import com.epam.quizapp.util.ScannerUtility;

@Configuration
@ComponentScan(basePackages = "com")
public class OnlineQuiz {
	
	private static final Logger LOGGER = LogManager.getLogger(OnlineQuiz.class);

	public static void main(String[] args) {
		
		LOGGER.info("Register/Login page !");
		LOGGER.info("Press 1 - Register");
		LOGGER.info("Press 2 - Login");
		LOGGER.info("Press 3 - Exit");
		
		try(AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(OnlineQuiz.class)) {
			
			int choice = ScannerUtility.openScanner().nextInt();
			
			if(choice == 1) {
				LOGGER.info("Great !");
				applicationContext.getBean(RegisterPage.class).view();
			}
			else if(choice == 2) {
				LOGGER.info("Great !");
				applicationContext.getBean(LoginPage.class).view();
			}
			else if(choice == 3) {
				LOGGER.info("Bye !");
			}
			else {
				LOGGER.info("Try again. Please choose out of given options !");
			}
		}
		catch(Exception exception) {
			exception.printStackTrace();
			LOGGER.error("Exception occured ! You might have not entered the correct option.");
		}
		finally {
			ScannerUtility.closeScanner();
		}
		
	}

}
