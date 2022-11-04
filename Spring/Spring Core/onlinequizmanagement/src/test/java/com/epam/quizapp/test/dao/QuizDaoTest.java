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

import com.epam.quizapp.dao.QuizDao;
import com.epam.quizapp.model.Quiz;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

@ExtendWith(value = { MockitoExtension.class })
class QuizDaoTest {
	
	@InjectMocks
	QuizDao quizDao;
	
	@Mock
	EntityManager entityManager;
	
	@Mock
	EntityManagerFactory entityManagerFactory;
	
	@Mock
	TypedQuery<Quiz> typedQuery;
	
	@Mock
	EntityTransaction entityTransaction;
	
	List<Quiz> quizList;
	
	Quiz quiz;
	
	@BeforeEach
	void setUp() {
		quiz = new Quiz();
		quiz.setId(1);
		quiz.setQuizTitle("Maths Quiz");
		quizList = new ArrayList<>();
		quizList.add(quiz);
	}
	
	@Test
	void getAllQuizTest() {
		
		when(entityManagerFactory.createEntityManager()).thenReturn(entityManager);
		when(entityManager.createQuery("from Quiz", Quiz.class)).thenReturn(typedQuery);
		when(typedQuery.getResultList()).thenReturn(quizList);
		
		List<Quiz> mockitoQuizList = quizDao.getAllQuiz();
		
		assertEquals(1, mockitoQuizList.size());
		
	}
	
	@Test
	void renameQuizTest() {
		
		when(entityManagerFactory.createEntityManager()).thenReturn(entityManager);
		when(entityManager.getTransaction()).thenReturn(entityTransaction);
		when(entityManager.find(Quiz.class, 1)).thenReturn(quiz);
		when(entityManager.createQuery("from Quiz", Quiz.class)).thenReturn(typedQuery);
		when(typedQuery.getResultList()).thenReturn(quizList);
		
		List<Quiz> mockitoQuizList = quizDao.renameQuiz(1, "Maths Quiz");
		
		assertEquals("Maths Quiz", mockitoQuizList.get(0).getQuizTitle());
				
	}
	
	@Test
	void addQuizTest() {

		when(entityManagerFactory.createEntityManager()).thenReturn(entityManager);
		when(entityManager.getTransaction()).thenReturn(entityTransaction);
		when(entityManager.createQuery("from Quiz", Quiz.class)).thenReturn(typedQuery);
		when(typedQuery.getResultList()).thenReturn(quizList);
		List<Quiz> mockitoQuizList = quizDao.addQuiz(quiz);
		
		assertEquals(1, mockitoQuizList.size());
		
	}
	
	@Test
	void deleteQuizTest() {
		
		when(entityManagerFactory.createEntityManager()).thenReturn(entityManager);
		when(entityManager.getTransaction()).thenReturn(entityTransaction);
		when(entityManager.find(Quiz.class, 2)).thenReturn(quiz);
		when(entityManager.createQuery("from Quiz", Quiz.class)).thenReturn(typedQuery);
		when(typedQuery.getResultList()).thenReturn(quizList);
		
		List<Quiz> mockitoQuizList = quizDao.deleteQuiz(2);
		
		assertEquals(1, mockitoQuizList.size());
		
	}

}
