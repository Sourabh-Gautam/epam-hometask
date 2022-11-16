package com.epam.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.epam.entity.Quiz;
import com.epam.repository.QuizRepository;

@Service
public class StudentService {
	
	QuizRepository quizRepository;

	public StudentService(QuizRepository quizRepository) {
		this.quizRepository = quizRepository;
	}

	public Quiz getQuizById(int quizId) {
		return quizRepository.findById(quizId).orElse(null);
	}

	public List<Quiz> getAllQuiz() {
		return quizRepository.findAll();
	}

}
