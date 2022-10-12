package com.epam.quizapp.ui;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.quizapp.annotation.Render;
import com.epam.quizapp.client.OnlineQuiz;
import com.epam.quizapp.util.Renderer;
import com.epam.quizapp.util.ScannerUtility;

public class StudentPage {
	
	private static final Logger LOGGER = LogManager.getLogger(StudentPage.class);

	@Render
	public void processStudentPage() {
		
		LOGGER.info("Below is the list of Quizes. Take any quiz !");

		Renderer.render(QuizLibraryPage.class);

		System.out.print("Do you want to continue (y/n) : ");

		if (ScannerUtility.openScanner().next().toLowerCase().equals("y")) {

			System.out.print("Enter quiz id to select : ");
			String quizId = ScannerUtility.openScanner().next();

			QuestionLibraryPage.getInstance().renderQuestionsForStudent(quizId);
			processStudentPage();
		}
		else {
			OnlineQuiz.main(null);
		}
	}

	public static StudentPage getInstance() {
		return new StudentPage();
	}

}
