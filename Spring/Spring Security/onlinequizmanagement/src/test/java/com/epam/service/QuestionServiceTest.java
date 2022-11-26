package com.epam.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.epam.entity.Question;
import com.epam.repo.QuestionRepository;

@SpringBootTest
class QuestionServiceTest {
	
	@MockBean
	QuestionRepository questionRepository;
	
	@Autowired
	QuestionService questionService;
	
	@Test
	void findQuestionsByQuizIdTest() {
		@SuppressWarnings("unchecked")
		List<Question> questionList = mock(List.class);
		when(questionRepository.findQuestionsByQuizId(1)).thenReturn(questionList);
		List<Question> result = questionService.findQuestionsByQuizId(1);
		assertNotNull(result);
	}
	
	@Test
	void addQuestionTest() {
		Question question = mock(Question.class);
		when(questionRepository.save(question)).thenReturn(question);
		Question result = questionService.addQuestion(question);
		assertNotNull(result);
	}
	
	@Test
	void deleteQuestionByIdTest() {
		doNothing().when(questionRepository).deleteById(1);
		int result = questionService.deleteQuestionById(1);
		assertEquals(1, result);
	}
	
	@Test
	void findQuestionByIdTest() {
		Question question = mock(Question.class);
		when(questionRepository.findById(1)).thenReturn(Optional.ofNullable(question));
		Optional<Question> result = questionService.findQuestionById(1);
		assertNotNull(result.get());
	}
	
}
