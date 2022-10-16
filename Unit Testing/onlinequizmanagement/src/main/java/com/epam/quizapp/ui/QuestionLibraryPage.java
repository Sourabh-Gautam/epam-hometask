package com.epam.quizapp.ui;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.quizapp.model.Option;
import com.epam.quizapp.model.Question;
import com.epam.quizapp.operation.QuestionOperation;
import com.epam.quizapp.util.ScannerUtility;

public class QuestionLibraryPage {
	
	private static final Logger LOGGER = LogManager.getLogger(QuestionLibraryPage.class);

	public List<Question> renderQuestionsForStudent(String quizId) {

		List<Question> questionList = QuestionOperation.getInstance().getQuestions(quizId);

		if (questionList == null || questionList.isEmpty()) {
			LOGGER.info("Quiz is empty. Please Choose another quiz !");
			return questionList;
		}

		LOGGER.info("-------------------------------------------------------------------------");
		int correctAnswerCount = 0;
		for (int i = 0; i < questionList.size(); i++) {
			Question question = questionList.get(i);
			LOGGER.info(question.getId() + ".| " + question.getQuestionStatement() + "");

			Option correctOption = null;

			List<Option> optionList = question.getOptionList();
			for (int j = 0; j < optionList.size(); j++) {
				Option option = optionList.get(j);
				if (option.isCorrect())
					correctOption = option;
				LOGGER.info(option.getId() + ". " + option.getOptionName());
			}

			System.out.print("Choose an option : ");
			String choseOptionId = ScannerUtility.openScanner().next();

			if (correctOption.getId().toLowerCase().equals(choseOptionId.toLowerCase())) {
				LOGGER.info("Great ! Answer is correct.");
				correctAnswerCount++;
			} else {
				LOGGER.info("Sorry ! The correct answer is [ " + correctOption.getId() + ". "
						+ correctOption.getOptionName() + " ]");
			}
			try {
				if (i != questionList.size() - 1) {
					LOGGER.info("Enter for next question...");
					System.in.read();
				} else {
					LOGGER.info("Quiz Finished ! You scored " + correctAnswerCount + " / " + (i + 1) + "");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		LOGGER.info("-------------------------------------------------------------------------");
		return questionList;
	}

	public void renderQuestionsForAdmin(String quizId) {

		List<Question> questionList = QuestionOperation.getInstance().getQuestions(quizId);

		if (questionList == null || questionList.isEmpty()) {
			LOGGER.info("Quiz is empty. Add some question !");
			LOGGER.info("Press 0 - Exit");
			LOGGER.info("Press 1 - Add Question");
			String choice = ScannerUtility.openScanner().next();
			if (!choice.equals("0") && !choice.equals("2")) {
				actionOnQuestion(choice, quizId);
			}
		}
		else {
			LOGGER.info("-------------------------------------------------------------------------");
			for (int i = 0; i < questionList.size(); i++) {
				Question question = questionList.get(i);
				LOGGER.info(question.getId() + ".| " + question.getQuestionStatement() + "");

				List<Option> optionList = question.getOptionList();
				for (int j = 0; j < optionList.size(); j++) {
					Option option = optionList.get(j);
					if (option.isCorrect()) {
						LOGGER.info(option.getId() + ". " + option.getOptionName() + " - Correct");					
					}else {
						LOGGER.info(option.getId() + ". " + option.getOptionName());					
					}
				}
			}
			LOGGER.info("-------------------------------------------------------------------------");
			
			LOGGER.info("Press 0 - Exit");
			LOGGER.info("Press 1 - Add Question");
			LOGGER.info("Press 2 - Delete Question");

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
			
			System.out.print("Enter question statement : ");
			ScannerUtility.openScanner().nextLine();
			String questionStatement = ScannerUtility.openScanner().nextLine();

			String correctOption = "";
			
			System.out.print("Enter option 1 : ");
			String option1 = ScannerUtility.openScanner().nextLine();
			System.out.print("Is is correct option (y/n) : ");
			if (ScannerUtility.openScanner().nextLine().toLowerCase().equals("y")) {
				correctOption = "1";
			}
			System.out.print("Enter option 2 : ");
			String option2 = ScannerUtility.openScanner().nextLine();
			System.out.print("Is is correct option (y/n) : ");
			if (ScannerUtility.openScanner().nextLine().toLowerCase().equals("y")) {
				correctOption = "2";
			}
			System.out.print("Enter option 3 : ");
			String option3 = ScannerUtility.openScanner().nextLine();
			System.out.print("Is is correct option (y/n) : ");
			if (ScannerUtility.openScanner().nextLine().toLowerCase().equals("y")) {
				correctOption = "3";
			}
			System.out.print("Enter option 4 : ");
			String option4 = ScannerUtility.openScanner().nextLine();
			System.out.print("Is is correct option (y/n) : ");
			if (ScannerUtility.openScanner().nextLine().toLowerCase().equals("y")) {
				correctOption = "4";
			}

			if(correctOption.isEmpty()) {
				LOGGER.info("One option should be correct ! Do you want to add again ? (y/n)");
				if (ScannerUtility.openScanner().nextLine().toLowerCase().equals("y")) {
					actionOnQuestion(action, quizId);
				}
			}
			else {
				questionOperation.addQuestion(quizId, questionStatement, option1, option2, option3, option4, correctOption);
				LOGGER.info("Question added successfully !");
			}
			
		} else if (action.equals("2")) {
			System.out.print("Enter question id : ");
			String questionId = ScannerUtility.openScanner().next();
			if (questionId.isEmpty()) {
				LOGGER.info("Question id cannot be blank. Try again !");
			}else {
				if(questionOperation.deleteQuestion(quizId, questionId)==null) {
					LOGGER.info("Question id is not correct !");
				}else {
					LOGGER.info("Question deleted successfully !");
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
