package com.epam.quizapp.test.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.epam.quizapp.dao.QuestionDao;
import com.epam.quizapp.database.QuizCollection;
import com.epam.quizapp.model.Option;
import com.epam.quizapp.model.Question;

class QuestionDaoTest {
	
	int questionCount;
	
	@BeforeEach
	void supplyQuestionCoutn() {
		questionCount = QuizCollection.getInstance().getQuiz("1").getQuestionList().size();
	}

	@Test
	void getQuestionListTest() {
				
		List<Question> questionList = QuestionDao.getQuestionList("1");
		
		int newQuestionCount = questionList.size();
		
		assertEquals(questionCount, newQuestionCount);
	}
	
	
	@Test
	void addQuestionTest() {

		Question question = new Question();
		question.setQuestionStatement("Who is the smallest planet ?");
		question.setOptionList(List.of(new Option("A", "Mercury", true), new Option("B", "Saturn", false), new Option("C", "Venus", false), new Option("D", "Mars", false)));
		
		List<Question> questionList = QuestionDao.addQuestion("1", question);
		
		int questionCountAfterAdd = questionList.size();
		
		assertEquals(questionCount+1, questionCountAfterAdd);
	}
	
	@Test
	void deleteQuestionTest() {

		List<Question> questionList = QuestionDao.deleteQuestion("1", "1");
		
		int questionCountAfterDelete = questionList.size();
		
		assertEquals(questionCount, questionCountAfterDelete+1);
	}
	
}
