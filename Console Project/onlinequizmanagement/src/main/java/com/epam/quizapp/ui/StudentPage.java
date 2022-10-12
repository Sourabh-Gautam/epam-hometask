package com.epam.quizapp.ui;

import com.epam.quizapp.annotation.Render;
import com.epam.quizapp.client.OnlineQuiz;
import com.epam.quizapp.util.Renderer;
import com.epam.quizapp.util.ScannerUtility;

public class StudentPage {

	@Render
	public void processStudentPage() {
		
		System.out.println("\nBelow is the list of Quizes. Take any quiz !\n");

		Renderer.render(QuizLibraryPage.class);

		System.out.print("\nDo you want to continue (y/n) : ");

		if (ScannerUtility.openScanner().next().toLowerCase().equals("y")) {

			System.out.print("\nEnter quiz id to select : ");
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
