package com.epam.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.epam.entity.Question;
import com.epam.entity.User;
	
@SpringBootTest
class QuestionRepositoryTest {
	
	@Autowired
	private QuestionRepository questionRepository;
	
	@Test
	void findQuestionsByQuizIdTest() {
		List<Question> questionList = questionRepository.findQuestionsByQuizId(1);
		assertNotNull(questionList);
	}
	
}
