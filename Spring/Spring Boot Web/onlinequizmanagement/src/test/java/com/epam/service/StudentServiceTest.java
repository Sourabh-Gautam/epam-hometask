package com.epam.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.epam.entity.Quiz;
import com.epam.exception.QuizNotFoundException;
import com.epam.repository.QuizRepository;

@SpringBootTest
class StudentServiceTest {
	
	@MockBean
	QuizRepository quizRepository;
	
	@Autowired
	StudentService studentService;
	
	private Quiz quiz;
	
	@BeforeEach
	void setUp() throws Exception {
		quiz = Quiz.builder()
				.quizTitle("Maths Quiz")
				.build();
	}
	
	@Test
	void getAllQuizTest() {
		List<Quiz> quizList = List.of(quiz);
		when(quizRepository.findAll()).thenReturn(quizList);
		List<Quiz> result = studentService.getAllQuiz();
		assertNotNull(result);
	}
	
	@Test
	void getQuizByIdTest() throws QuizNotFoundException {
		when(quizRepository.findById(1)).thenReturn(Optional.ofNullable(quiz));
		Quiz result = studentService.getQuizById(1);
		assertNotNull(result);
	}
	
	@Test
	void getQuizByIdButQuizNotFoundTest() throws QuizNotFoundException {
		when(quizRepository.findById(1)).thenReturn(Optional.ofNullable(quiz));
		assertThrows(QuizNotFoundException.class, () -> {studentService.getQuizById(1);});
	}
	
}
