package com.epam.quizapp.ui;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.epam.quizapp.client.OnlineQuiz;
import com.epam.quizapp.util.ScannerUtility;

@Component
public class StudentPage implements Page, ApplicationContextAware {
	
	ApplicationContext applicationContext;
	
	private static final Logger LOGGER = LogManager.getLogger(StudentPage.class);

	public void view() {
		
		LOGGER.info("Below is the list of Quizes. Take any quiz !");

		applicationContext.getBean(QuizLibraryPage.class).view();

		LOGGER.info("Do you want to continue (y/n) : ");

		if (ScannerUtility.openScanner().next().equalsIgnoreCase("y")) {

			LOGGER.info("Enter quiz id to select : ");
			String quizId = ScannerUtility.openScanner().next();
			applicationContext.getBean(QuestionLibraryPage.class).renderQuestionsForStudent(quizId);
			view();
		}
		else {
			OnlineQuiz.main(null);
		}
	}
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

}
