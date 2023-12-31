package com.epam.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.epam.entity.Question;
import com.epam.entity.Quiz;
import com.epam.exception.QuizNotFoundException;
import com.epam.repository.QuestionRepository;
import com.epam.repository.QuizRepository;

@SpringBootTest
class AdminServiceTest {
	
	@MockBean
	QuizRepository quizRepository;
	
	@MockBean
	QuestionRepository questionRepository;
	
	@Autowired
	AdminService adminService = new AdminService(quizRepository, questionRepository);
	
	private Quiz quiz;
	
	@BeforeEach
	void setUp() throws Exception {
		quiz = Quiz.builder()
				.quizTitle("Maths Quiz")
				.build();
	}
	
	@Test
	void createQuizTest() {
		when(quizRepository.save(quiz)).thenReturn(quiz);
		Quiz result = adminService.createQuiz(quiz);
		assertNotNull(result);
	}
	
	@Test
	void getAllQuizTest() {
		List<Quiz> quizList = List.of(quiz);
		when(quizRepository.findAll()).thenReturn(quizList);
		List<Quiz> result = adminService.getAllQuiz();
		assertNotNull(result);
	}
	
	@Test
	void getQuizByIdTest() throws QuizNotFoundException {
		when(quizRepository.findById(1)).thenReturn(Optional.ofNullable(quiz));
		Quiz result = adminService.getQuizById(1);
		assertNotNull(result);
	}
	
	@Test
	void getQuizByIdButQuizNotFoundTest() throws QuizNotFoundException {
		when(quizRepository.findById(1)).thenReturn(Optional.ofNullable(null));
		assertThrows(QuizNotFoundException.class, ()-> {adminService.getQuizById(1);});
	}
	
	@Test
	void findQuestionsByQuizIdTest() {
		@SuppressWarnings("unchecked")
		List<Question> questionList = mock(List.class);
		when(questionRepository.findQuestionsByQuizId(1)).thenReturn(questionList);
		List<Question> result = adminService.findQuestionsByQuizId(1);
		assertNotNull(result);
	}
	
	@Test
	void addQuestionTest() {
		Question question = mock(Question.class);
		when(questionRepository.save(question)).thenReturn(question);
		Question result = adminService.addQuestion(question);
		assertNotNull(result);
	}
	
	@Test
	void deleteQuestionByIdTest() {
		doNothing().when(questionRepository).deleteById(1);
		int result = adminService.deleteQuestionById(1);
		assertEquals(1, result);
	}
	
	@Test
	void deleteQuizByIdTest() {
		doNothing().when(quizRepository).deleteById(1);
		int result = adminService.deleteQuizById(1);
		assertEquals(1, result);
	}
	
	
}
