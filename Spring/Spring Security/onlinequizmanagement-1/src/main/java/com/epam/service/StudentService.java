package com.epam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.entity.Quiz;
import com.epam.exception.QuizNotFoundException;
import com.epam.repository.QuizRepository;

@Service
public class StudentService {
	
	@Autowired
	private QuizRepository quizRepository;

	public StudentService(QuizRepository quizRepository) {
		this.quizRepository = quizRepository;
	}

	public Quiz getQuizById(int quizId) throws QuizNotFoundException {
		return quizRepository.findById(quizId).orElseThrow(QuizNotFoundException::new);
	}

	public List<Quiz> getAllQuiz() {
		return quizRepository.findAll();
	}

}
