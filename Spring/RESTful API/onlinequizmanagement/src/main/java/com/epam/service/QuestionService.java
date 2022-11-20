package com.epam.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.entity.Question;
import com.epam.repo.QuestionRepository;

@Service
public class QuestionService {

	@Autowired
	QuestionRepository questionRepository;

	public List<Question> findQuestionsByQuizId(int quizId) {
		return questionRepository.findQuestionsByQuizId(quizId);
	}

	public Question addQuestion(Question question) {
		return questionRepository.save(question);
	}

	public int deleteQuestionById(int questionId) {
		questionRepository.deleteById(questionId);
		return 1;
	}

	public Optional<Question> findQuestionById(int questionId) {
		return questionRepository.findById(questionId);
	}

}
