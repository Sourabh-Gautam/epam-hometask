package com.epam.quizapp.test.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.epam.quizapp.dao.QuestionDao;
import com.epam.quizapp.model.Question;
import com.epam.quizapp.model.Quiz;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

@ExtendWith(value = { MockitoExtension.class })
class QuestionDaoTest {
	
	@InjectMocks
	QuestionDao questionDao;
	
	@Mock
	EntityManager entityManager;
	
	@Mock
	EntityManagerFactory entityManagerFactory;
	
	@Mock
	TypedQuery<Question> typedQuery;
	
	@Mock
	EntityTransaction entityTransaction;
	
	@Mock
	Quiz quiz;
	
	List<Question> questionList;
	
	Question question;
	
	@BeforeEach
	void setUp() {
		question = new Question();
		question.setId(1);
		question.setQuestionStatement("What is moon ?");
		questionList = new ArrayList<>();
		questionList.add(question);
	}

	@Test
	void getQuestionListTest() {
		
		when(entityManagerFactory.createEntityManager()).thenReturn(entityManager);
		when(entityManager.find(Quiz.class, 1)).thenReturn(quiz);
		when(quiz.getQuestionList()).thenReturn(questionList);
		List<Question> mockitoQuestionList = questionDao.getQuestionList(1);
		
		assertEquals(1, mockitoQuestionList.size());
		
	}
	
	
	@Test
	void addQuestionTest() {

		when(entityManagerFactory.createEntityManager()).thenReturn(entityManager);
		when(entityManager.find(Quiz.class, 1)).thenReturn(quiz);
		when(entityManager.getTransaction()).thenReturn(entityTransaction);
		when(quiz.getQuestionList()).thenReturn(questionList);
		List<Question> mockitoQuestionList = questionDao.addQuestion(1, question);
		assertEquals(2, mockitoQuestionList.size());

	}
	
	@Test
	void deleteQuestionTest() {
		
		int quizId = 1;
		int questionId = 1;
		when(entityManagerFactory.createEntityManager()).thenReturn(entityManager);
		when(entityManager.getTransaction()).thenReturn(entityTransaction);
		when(entityManager.find(Question.class, questionId)).thenReturn(question);
		when(entityManager.find(Quiz.class, questionId)).thenReturn(quiz);
		when(quiz.getQuestionList()).thenReturn(questionList);
		List<Question> mockitoQuestionList = questionDao.deleteQuestion(quizId, questionId);
		
		assertEquals(1, mockitoQuestionList.size());
		
	}
	
}
