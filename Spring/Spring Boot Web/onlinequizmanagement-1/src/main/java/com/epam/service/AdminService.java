package com.epam.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.epam.entity.Question;
import com.epam.entity.Quiz;
import com.epam.exception.QuizNotFoundException;
import com.epam.repository.QuestionRepository;
import com.epam.repository.QuizRepository;

@Service
public class AdminService {
	
	QuizRepository quizRepository;
	QuestionRepository questionRepository;
	
	public AdminService(QuizRepository quizRepository, QuestionRepository questionRepository) {
		super();
		this.quizRepository = quizRepository;
		this.questionRepository = questionRepository;
	}

	public Quiz createQuiz(Quiz quiz) {
		return quizRepository.save(quiz);
	}

	public List<Quiz> getAllQuiz() {
		return quizRepository.findAll();
	}
	
	public Quiz getQuizById(int quizId) throws QuizNotFoundException {
		return quizRepository.findById(quizId).orElseThrow(QuizNotFoundException::new);
	}
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

	public int deleteQuizById(int quizId) {
		quizRepository.deleteById(quizId);
		return 1;
	}
	
}
