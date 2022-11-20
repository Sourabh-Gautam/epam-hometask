package com.epam.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.epam.entity.Quiz;
import com.epam.exception.ResourceNotFoundException;
import com.epam.repo.QuizRepository;

@SpringBootTest
class QuizServiceTest {
	
	@MockBean
	QuizRepository quizRepository;
	
	@Autowired
	QuizService quizService;
	
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
		Quiz result = quizService.createQuiz(quiz);
		assertNotNull(result);
	}
	
	@Test
	void getAllQuizTest() {
		List<Quiz> quizList = List.of(quiz);
		when(quizRepository.findAll()).thenReturn(quizList);
		List<Quiz> result = quizService.getAllQuiz();
		assertNotNull(result);
	}
	
	@Test
	void getQuizByIdTest() {
		when(quizRepository.findById(1)).thenReturn(Optional.ofNullable(quiz));
		Optional<Quiz> result = quizService.getQuizById(1);
		assertNotNull(result.get());
	}
	
	@Test
	void deleteQuizByIdTest() {
		doNothing().when(quizRepository).deleteById(1);
		Integer result = quizService.deleteQuizById(1);
		assertThat(result).isEqualTo(1);
	}
	
	@Test
	void renameQuizTest() throws ResourceNotFoundException {
		when(quizRepository.save(quiz)).thenReturn(quiz);
		Quiz result = quizService.renameQuiz(quiz);
		assertNotNull(result);
	}
	
}
