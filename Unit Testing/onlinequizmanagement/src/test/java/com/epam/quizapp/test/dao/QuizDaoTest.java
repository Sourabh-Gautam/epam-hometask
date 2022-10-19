package com.epam.quizapp.test.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.epam.quizapp.dao.QuizDao;
import com.epam.quizapp.database.QuizCollection;
import com.epam.quizapp.model.Quiz;

class QuizDaoTest {

	int quizCount;
	
	@BeforeEach
	void supplyQuizCount() {
		quizCount = QuizCollection.getInstance().getQuizList().size();
	}
	
	@Test
	void getQuizListTest() {
		
		
		List<Quiz> quizList = QuizDao.getAllQuiz();
		
		assertEquals(quizCount, quizList.size());
	}
	
	@Test
	void renameQuizTest() {

		QuizDao.renameQuiz("2", "General Knowledge Quiz");
				
		assertEquals("General Knowledge Quiz", QuizCollection.getInstance().getQuiz("2").getQuizTitle());
	}
	
	@Test
	void addQuizTest() {
		
		int quizCount = QuizCollection.getInstance().getQuizList().size();
		
		Quiz quiz = new Quiz();
		quiz.setId("6");
		quiz.setQuizTitle("Java Quiz");
		
		QuizDao.addQuiz(quiz);
		
		int quizCountAfterAdd = QuizCollection.getInstance().getQuizList().size();
		
		assertEquals(quizCount+1, quizCountAfterAdd);
	}
	
	@Test
	void deleteQuizTest() {
		
		int quizCount = QuizCollection.getInstance().getQuizList().size();
		
		QuizDao.deleteQuiz("2");
		
		int quizCountAfterDelete = QuizCollection.getInstance().getQuizList().size();
		
		assertEquals(quizCount, quizCountAfterDelete+1);
	}
	
}
