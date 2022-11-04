package com.epam.quizapp.ui;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.epam.quizapp.client.OnlineQuiz;
import com.epam.quizapp.util.ScannerUtility;

@Component
public class AdminPage implements Page, ApplicationContextAware {

	ApplicationContext applicationContext;
	private static final Logger LOGGER = LogManager.getLogger(AdminPage.class);
	
	public void view() {
		LOGGER.info("Welcome to Admin Page !");

		LOGGER.info("Press 1 - Create new quiz");
		LOGGER.info("Press 2 - Operate an existing quiz");
		LOGGER.info("Press 3 - Exit");

		String choice = ScannerUtility.openScanner().next();

		if (choice.equals("1")) {
			applicationContext.getBean(QuizLibraryPage.class).creatingQuiz();
		} else if (choice.equals("2")) {
			applicationContext.getBean(QuizLibraryPage.class).operatingQuiz();
		} else if (choice.equals("3")) {
			OnlineQuiz.main(null);
		}

	}
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

}
