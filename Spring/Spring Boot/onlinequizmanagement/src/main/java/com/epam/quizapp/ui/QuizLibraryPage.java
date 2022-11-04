package com.epam.quizapp.ui;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.epam.quizapp.model.Quiz;
import com.epam.quizapp.operation.QuizOperation;
import com.epam.quizapp.util.ScannerUtility;

@Component
public class QuizLibraryPage implements Page, ApplicationContextAware {
	
	@Autowired
	QuizOperation quizOperation;
	
	ApplicationContext applicationContext;
	private static final Logger LOGGER = LogManager.getLogger(QuizLibraryPage.class);

	public void view() {

		List<Quiz> quizList = quizOperation.getQuizes();

		if (quizList.isEmpty()) {
			LOGGER.info("No quiz available !");
			applicationContext.getBean(AdminPage.class).view();
		}

		for (int i = 0; i < quizList.size(); i++) {
			LOGGER.info("Quiz {} - {}", quizList.get(i).getId(), quizList.get(i).getQuizTitle());
		}
	}

	public void creatingQuiz() {
		
		LOGGER.info("Enter Quiz Name : ");
		ScannerUtility.openScanner().nextLine();
		String quizTitle =ScannerUtility.openScanner().nextLine();
		quizOperation.createQuiz(quizTitle);
		operatingQuiz();
		
	}

	public void operatingQuiz() {
		LOGGER.info("[- Quiz Library -]");

		this.view();

		LOGGER.info("Do you want to continue (y/n) : ");

		if (ScannerUtility.openScanner().next().equalsIgnoreCase("y")) {

			LOGGER.info("Enter quiz number to select : ");
			String quizId = ScannerUtility.openScanner().next();

			List<Quiz> quizList = quizOperation.getQuizes();

			boolean flag = true;
			for (Quiz quiz : quizList) {
				if (String.valueOf(quiz.getId()).equals(quizId)) {
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
			applicationContext.getBean(AdminPage.class).view();
		}

	}

	public void quizActions(Quiz quiz) {
		LOGGER.info("You selected {} !", quiz.getQuizTitle());
		LOGGER.info("Press 0 - Exit");
		LOGGER.info("Press 1 - Delete");
		LOGGER.info("Press 2 - Rename");
		LOGGER.info("Press 3 - View");

		String operationChoice = ScannerUtility.openScanner().next();
		switch (operationChoice) {
		case "0":
			applicationContext.getBean(AdminPage.class).view();
			return;
		case "1":
			quizOperation.deleteQuiz(String.valueOf(quiz.getId()));
			break;
		case "2":
			LOGGER.info("Enter new quiz title : ");
			ScannerUtility.openScanner().nextLine();
			String newQuizTitle = ScannerUtility.openScanner().nextLine();
			quizOperation.renameQuiz(String.valueOf(quiz.getId()), newQuizTitle);
			break;
		case "3":
			applicationContext.getBean(QuestionLibraryPage.class).renderQuestionsForAdmin(String.valueOf(quiz.getId()));
			break;
			
		default:
			LOGGER.info("Please enter correct operation number !");
			quizActions(quiz);
		}
		operatingQuiz();
	}
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

}
