package com.epam.quizapp.ui;

import java.util.List;

import com.epam.quizapp.annotation.Render;
import com.epam.quizapp.model.Quiz;
import com.epam.quizapp.operation.QuizOperation;
import com.epam.quizapp.util.Renderer;
import com.epam.quizapp.util.ScannerUtility;

public class QuizLibraryPage {

	@Render
	public void renderQuizes() {

		List<Quiz> quizList = QuizOperation.getInstance().getQuizes();

		if (quizList.isEmpty()) {
			System.out.println("No quiz available !");
			return;
		}

		for (int i = 0; i < quizList.size(); i++) {
			System.out.println("Quiz " + quizList.get(i).getId() + " - " + quizList.get(i).getQuizTitle());
		}
	}

	public void creatingQuiz() {
		
		System.out.print("\nEnter Quiz Id : ");
		String quizId =ScannerUtility.openScanner().next();
		
		System.out.print("Enter Quiz Name : ");
		ScannerUtility.openScanner().nextLine();
		String quizName =ScannerUtility.openScanner().nextLine();
		
		QuizOperation.getInstance().createQuiz(quizId, quizName);
		operatingQuiz();
	}

	public void operatingQuiz() {
		System.out.println("\n[- Quiz Library -]\n");

		Renderer.render(QuizLibraryPage.class);

		System.out.print("\nDo you want to continue (y/n) : ");

		if (ScannerUtility.openScanner().next().toLowerCase().equals("y")) {

			System.out.print("\nEnter quiz id to select : ");
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
				System.out.println("\nPlease enter correct quiz id.");
				operatingQuiz();
			}

		} else {
			Renderer.render(AdminPage.class);
		}

	}

	public void quizActions(Quiz quiz) {
		System.out.println("\nYou selected " + quiz.getQuizTitle() + " !\n");
		System.out.println("Press 0 - Exit");
		System.out.println("Press 1 - Delete");
		System.out.println("Press 2 - Rename");
		System.out.println("Press 3 - View");

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
			System.out.println("\nEnter new quiz title : ");
			ScannerUtility.openScanner().nextLine();
			String newQuizTitle = ScannerUtility.openScanner().nextLine();
			quizOperations.renameQuiz(quiz.getId(), newQuizTitle);
			break;
		case "3":
			QuestionLibraryPage.getInstance().renderQuestionsForAdmin(quiz.getId());
			break;
			
		default:
			System.out.println("Please enter correct operation number !");
			quizActions(quiz);
		}
		operatingQuiz();
	}

	public static QuizLibraryPage getInstance() {
		return new QuizLibraryPage();
	}

}
