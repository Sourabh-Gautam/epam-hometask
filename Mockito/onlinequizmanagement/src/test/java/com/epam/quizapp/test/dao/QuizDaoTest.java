package com.epam.quizapp.test.dao;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.epam.quizapp.dao.QuizDao;
import com.epam.quizapp.model.Quiz;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

@ExtendWith(value = { MockitoExtension.class })
class QuizDaoTest {
	
	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("my-persistence-unit");

	private QuizDao quizDao;
	List<Quiz> mockQuizList;
	
	@Mock
	private EntityManager manager;
	
	@BeforeEach
	void supplyQuizCount() {
		quizDao = QuizDao.getInstance();
		manager = factory.createEntityManager();
		
		Quiz quiz = new Quiz();
		quiz.setId(1);
		quiz.setQuizTitle("Hindi Quiz");
		mockQuizList = new ArrayList<>();
		mockQuizList.add(quiz);
	}
	
	@Test
	void getAllQuizTest() {
		
		when(manager.createQuery(anyString()).getResultList()).thenReturn(mockQuizList);
		
	}
	
	@Test
	void renameQuizTest() {

				
	}
	
	@Test
	void addQuizTest() {
		
	}
	
	@Test
	void deleteQuizTest() {

	}
	
}
