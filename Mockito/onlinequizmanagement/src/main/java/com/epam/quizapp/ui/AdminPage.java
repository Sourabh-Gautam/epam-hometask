package com.epam.quizapp.ui;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.quizapp.annotation.Render;
import com.epam.quizapp.client.OnlineQuiz;
import com.epam.quizapp.util.ScannerUtility;

public class AdminPage {

	private static final Logger LOGGER = LogManager.getLogger(AdminPage.class);
	
	@Render
	public void processAdminPage() {
		LOGGER.info("Welcome to Admin Page !");

		LOGGER.info("Press 1 - Create new quiz");
		LOGGER.info("Press 2 - Operate an existing quiz");
		LOGGER.info("Press 3 - Exit");

		String choice = ScannerUtility.openScanner().next();

		if (choice.equals("1")) {
			QuizLibraryPage.getInstance().creatingQuiz();
		} else if (choice.equals("2")) {
			QuizLibraryPage.getInstance().operatingQuiz();
		} else if (choice.equals("3")) {
			OnlineQuiz.main(null);
		}

	}

	public static AdminPage getInstance() {
		return new AdminPage();
	}

}
