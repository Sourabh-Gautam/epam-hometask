package com.epam.quizapp.ui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.quizapp.model.Option;
import com.epam.quizapp.model.Question;
import com.epam.quizapp.operation.QuestionOperation;
import com.epam.quizapp.util.ScannerUtility;

public class QuestionLibraryPage {
	
	private static final String SEPARATOR = "-------------------------------------------------------------------------";
	
	private static final Logger LOGGER = LogManager.getLogger(QuestionLibraryPage.class);

	public List<Question> renderQuestionsForStudent(String quizId) {

		List<Question> questionList = QuestionOperation.getInstance().getQuestions(quizId);

		if (questionList == null || questionList.isEmpty()) {
			LOGGER.info("Quiz is empty. Please Choose another quiz !");
			return questionList;
		}

		LOGGER.info(SEPARATOR);
		int correctAnswerCount = 0;
		for (int i = 0; i < questionList.size(); i++) {
			Question question = questionList.get(i);
			LOGGER.info("{}.| {}", question.getId(), question.getQuestionStatement());

			Option correctOption = new Option();

			List<Option> optionList = question.getOptionList();
			for (int j = 0; j < optionList.size(); j++) {
				Option option = optionList.get(j);
				if (option.isCorrect())
					correctOption = option;
				LOGGER.info("{}. {}", option.getId(), option.getOptionName());
			}

			LOGGER.info("Choose an option : ");
			String choseOptionId = ScannerUtility.openScanner().next();

			if (correctOption.getId().equalsIgnoreCase(choseOptionId)) {
				LOGGER.info("Great ! Answer is correct.");
				correctAnswerCount++;
			} else {
				LOGGER.info("Sorry ! The correct answer is [ {}. {} ] ", correctOption.getId(), correctOption.getOptionName());
			}
			try {
				if (i != questionList.size() - 1) {
					LOGGER.info("Enter for next question...");
					System.in.read();
				} else {
					LOGGER.info("Quiz Finished ! You scored {} / {}", correctAnswerCount, i+1);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		LOGGER.info(SEPARATOR);
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
			LOGGER.info(SEPARATOR);
			for (int i = 0; i < questionList.size(); i++) {
				Question question = questionList.get(i);
				LOGGER.info("{}.| {}", question.getId(), question.getQuestionStatement());

				List<Option> optionList = question.getOptionList();
				for (int j = 0; j < optionList.size(); j++) {
					Option option = optionList.get(j);
					if (option.isCorrect()) {
						LOGGER.info("{}. {} - Correct", option.getId(), option.getOptionName());					
					}else {
						LOGGER.info("{}. {}", option.getId(), option.getOptionName());					
					}
				}
			}
			LOGGER.info(SEPARATOR);
			
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
		
		String correctOptionAskingStmt = "Is is correct option (y/n) : ";
		
		QuestionOperation questionOperation = new QuestionOperation();
		
		if (action.equals("1")) {
			// Add Question into quiz
			
			LOGGER.info("Enter question statement : ");
			ScannerUtility.openScanner().nextLine();
			String questionStatement = ScannerUtility.openScanner().nextLine();

			String correctOption = "";
			
			LOGGER.info("Enter option 1 : ");
			String option1 = ScannerUtility.openScanner().nextLine();
			if (ScannerUtility.openScanner().nextLine().equalsIgnoreCase("y")) {
				correctOption = "1";
			}
			LOGGER.info("Enter option 2 : ");
			String option2 = ScannerUtility.openScanner().nextLine();
			LOGGER.info(correctOptionAskingStmt);
			if (ScannerUtility.openScanner().nextLine().equalsIgnoreCase("y")) {
				correctOption = "2";
			}
			LOGGER.info("Enter option 3 : ");
			String option3 = ScannerUtility.openScanner().nextLine();
			LOGGER.info(correctOptionAskingStmt);
			if (ScannerUtility.openScanner().nextLine().equalsIgnoreCase("y")) {
				correctOption = "3";
			}
			LOGGER.info("Enter option 4 : ");
			String option4 = ScannerUtility.openScanner().nextLine();
			LOGGER.info(correctOptionAskingStmt);
			if (ScannerUtility.openScanner().nextLine().equalsIgnoreCase("y")) {
				correctOption = "4";
			}

			if(correctOption.isEmpty()) {
				LOGGER.info("One option should be correct ! Do you want to add again ? (y/n)");
				if (ScannerUtility.openScanner().nextLine().equalsIgnoreCase("y")) {
					actionOnQuestion(action, quizId);
				}
			}
			else {
				questionOperation.addQuestion(quizId, questionStatement, option1, option2, option3, option4, correctOption);
				LOGGER.info("Question added successfully !");
			}
			
		} else if (action.equals("2")) {
			LOGGER.info("Enter question id : ");
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
		return new ArrayList<>();
	}

	public static QuestionLibraryPage getInstance() {
		return new QuestionLibraryPage();
	}
}
