package com.epam.quizapp.ui;

import java.io.IOException;
import java.util.List;

import com.epam.quizapp.model.Option;
import com.epam.quizapp.model.Question;
import com.epam.quizapp.operation.QuestionOperation;
import com.epam.quizapp.util.ScannerUtility;

public class QuestionLibraryPage {

	public List<Question> renderQuestionsForStudent(String quizId) {

		List<Question> questionList = QuestionOperation.getInstance().getQuestions(quizId);

		if (questionList == null || questionList.isEmpty()) {
			System.out.println("Quiz is empty. Please Choose another quiz !");
			return questionList;
		}

		System.out.println("\n-------------------------------------------------------------------------\n");
		int correctAnswerCount = 0;
		for (int i = 0; i < questionList.size(); i++) {
			Question question = questionList.get(i);
			System.out.println(question.getId() + ".| " + question.getQuestionStatement());
			System.out.println();

			Option correctOption = null;

			List<Option> optionList = question.getOptionList();
			for (int j = 0; j < optionList.size(); j++) {
				Option option = optionList.get(j);
				if (option.isCorrect())
					correctOption = option;
				System.out.println(option.getId() + ". " + option.getOptionName());
			}

			System.out.print("\nChoose an option : ");
			String choseOptionId = ScannerUtility.openScanner().next();

			if (correctOption.getId().toLowerCase().equals(choseOptionId.toLowerCase())) {
				System.out.println("Great ! Answer is correct.");
				correctAnswerCount++;
			} else {
				System.out.println("Sorry ! The correct answer is [ " + correctOption.getId() + ". "
						+ correctOption.getOptionName() + " ]\n");
			}
			try {
				if (i != questionList.size() - 1) {
					System.out.println("\nEnter for next question...");
					System.in.read();
				} else {
					System.out.println("\nQuiz Finished ! You scored " + correctAnswerCount + " / " + (i + 1) + "\n");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println();
		}
		System.out.println("-------------------------------------------------------------------------\n");
		return questionList;
	}

	public void renderQuestionsForAdmin(String quizId) {

		List<Question> questionList = QuestionOperation.getInstance().getQuestions(quizId);

		if (questionList == null || questionList.isEmpty()) {
			System.out.println("\nQuiz is empty. Add some question !");
			System.out.println("\nPress 0 - Exit");
			System.out.println("Press 1 - Add Question");
			String choice = ScannerUtility.openScanner().next();
			if (!choice.equals("0") && !choice.equals("2")) {
				actionOnQuestion(choice, quizId);
			}
		}
		else {
			System.out.println("\n-------------------------------------------------------------------------\n");
			for (int i = 0; i < questionList.size(); i++) {
				Question question = questionList.get(i);
				System.out.println(question.getId() + ".| " + question.getQuestionStatement());
				System.out.println();

				List<Option> optionList = question.getOptionList();
				for (int j = 0; j < optionList.size(); j++) {
					Option option = optionList.get(j);
					if (option.isCorrect()) {
						System.out.println(option.getId() + ". " + option.getOptionName() + " - Correct");					
					}else {
						System.out.println(option.getId() + ". " + option.getOptionName());					
					}
				}
				System.out.println();
			}
			System.out.println("-------------------------------------------------------------------------\n");
			
			System.out.println("Press 0 - Exit");
			System.out.println("Press 1 - Add Question");
			System.out.println("Press 2 - Delete Question");

			String choice = ScannerUtility.openScanner().next();
			if (!choice.equals("0")) {
				actionOnQuestion(choice, quizId);
			}
		}
	}

	public List<Question> actionOnQuestion(String action, String quizId) {
		
		QuestionOperation questionOperation = new QuestionOperation();
		
		if (action.equals("1")) {
			// Add Question into quiz
			
			System.out.print("\nEnter question statement : ");
			ScannerUtility.openScanner().nextLine();
			String questionStatement = ScannerUtility.openScanner().nextLine();

			String correctOption = "";
			
			System.out.print("\nEnter option 1 : ");
			String option1 = ScannerUtility.openScanner().nextLine();
			System.out.print("Is is correct option (y/n) : ");
			if (ScannerUtility.openScanner().nextLine().toLowerCase().equals("y")) {
				correctOption = "1";
			}
			System.out.print("\nEnter option 2 : ");
			String option2 = ScannerUtility.openScanner().nextLine();
			System.out.print("Is is correct option (y/n) : ");
			if (ScannerUtility.openScanner().nextLine().toLowerCase().equals("y")) {
				correctOption = "2";
			}
			System.out.print("\nEnter option 3 : ");
			String option3 = ScannerUtility.openScanner().nextLine();
			System.out.print("Is is correct option (y/n) : ");
			if (ScannerUtility.openScanner().nextLine().toLowerCase().equals("y")) {
				correctOption = "3";
			}
			System.out.print("\nEnter option 4 : ");
			String option4 = ScannerUtility.openScanner().nextLine();
			System.out.print("Is is correct option (y/n) : ");
			if (ScannerUtility.openScanner().nextLine().toLowerCase().equals("y")) {
				correctOption = "4";
			}

			if(correctOption.isEmpty()) {
				System.out.println("\nOne option should be correct ! Do you want to add again ? (y/n)");
				if (ScannerUtility.openScanner().nextLine().toLowerCase().equals("y")) {
					actionOnQuestion(action, quizId);
				}
			}
			else {
				questionOperation.addQuestion(quizId, questionStatement, option1, option2, option3, option4, correctOption);
				System.out.println("\nQuestion added successfully !\n");
			}
			
		} else if (action.equals("2")) {
			System.out.print("\nEnter question id : ");
			String questionId = ScannerUtility.openScanner().next();
			if (questionId.isEmpty()) {
				System.out.println("Question id cannot be blank. Try again !");
			}else {
				if(questionOperation.deleteQuestion(quizId, questionId)==null) {
					System.out.println("Question id is not correct !");
				}else {
					System.out.println("Question deleted successfully !");
				}
			}
			
		} 
		renderQuestionsForAdmin(quizId);
		return null;
	}

	public static QuestionLibraryPage getInstance() {
		return new QuestionLibraryPage();
	}
}
