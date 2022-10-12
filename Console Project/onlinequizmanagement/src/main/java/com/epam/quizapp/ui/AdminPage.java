package com.epam.quizapp.ui;

import com.epam.quizapp.annotation.Render;
import com.epam.quizapp.client.OnlineQuiz;
import com.epam.quizapp.util.ScannerUtility;

public class AdminPage {

	@Render
	public void processAdminPage() {
		System.out.println("\nWelcome to Admin Page !");

		System.out.println("\nPress 1 - Create new quiz");
		System.out.println("Press 2 - Operate an existing quiz");
		System.out.println("Press 3 - Exit");

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
