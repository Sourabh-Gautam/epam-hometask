package com.epam.quizapp.ui;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.quizapp.annotation.Render;
import com.epam.quizapp.model.Quiz;
import com.epam.quizapp.operation.QuizOperation;
import com.epam.quizapp.util.Renderer;
import com.epam.quizapp.util.ScannerUtility;

public class QuizLibraryPage {
	
	private static final Logger LOGGER = LogManager.getLogger(QuizLibraryPage.class);

	@Render
	public void renderQuizes() {

		List<Quiz> quizList = QuizOperation.getInstance().getQuizes();

		if (quizList.isEmpty()) {
			LOGGER.info("No quiz available !");
			return;
		}

		for (int i = 0; i < quizList.size(); i++) {
			LOGGER.info("Quiz {} - {}", quizList.get(i).getId(), quizList.get(i).getQuizTitle());
		}
	}

	public void creatingQuiz() {
		
		LOGGER.info("Enter Quiz Id : ");
		String quizId =ScannerUtility.openScanner().next();
		
		LOGGER.info("Enter Quiz Name : ");
		ScannerUtility.openScanner().nextLine();
		String quizName =ScannerUtility.openScanner().nextLine();
		
		QuizOperation.getInstance().createQuiz(quizId, quizName);
		operatingQuiz();
	}

	public void operatingQuiz() {
		LOGGER.info("[- Quiz Library -]");

		Renderer.render(QuizLibraryPage.class);

		LOGGER.info("Do you want to continue (y/n) : ");

		if (ScannerUtility.openScanner().next().equalsIgnoreCase("y")) {

			LOGGER.info("Enter quiz id to select : ");
			String quizId = ScannerUtility.openScanner().next();

			List<Quiz> quizList = QuizOperation.getInstance().getQuizes();

			boolean flag = true;
			for (Quiz quiz : quizList) {
				if (quiz.getId().equals(quizId)) {
					flag = false;
					quizActions(quiz);
					break;
				}
			}

			if (flag) {
				LOGGER.info("Please enter correct quiz id.");
				operatingQuiz();
			}

		} else {
			Renderer.render(AdminPage.class);
		}

	}

	public void quizActions(Quiz quiz) {
		LOGGER.info("You selected {} !", quiz.getQuizTitle());
		LOGGER.info("Press 0 - Exit");
		LOGGER.info("Press 1 - Delete");
		LOGGER.info("Press 2 - Rename");
		LOGGER.info("Press 3 - View");

		QuizOperation quizOperations = QuizOperation.getInstance();

		String operationChoice = ScannerUtility.openScanner().next();
		switch (operationChoice) {
		case "0":
			Renderer.render(AdminPage.class);
			return;
		case "1":
			quizOperations.deleteQuiz(quiz.getId());
			break;
		case "2":
			LOGGER.info("Enter new quiz title : ");
			ScannerUtility.openScanner().nextLine();
			String newQuizTitle = ScannerUtility.openScanner().nextLine();
			quizOperations.renameQuiz(quiz.getId(), newQuizTitle);
			break;
		case "3":
			QuestionLibraryPage.getInstance().renderQuestionsForAdmin(quiz.getId());
			break;
			
		default:
			LOGGER.info("Please enter correct operation number !");
			quizActions(quiz);
		}
		operatingQuiz();
	}

	public static QuizLibraryPage getInstance() {
		return new QuizLibraryPage();
	}

}
