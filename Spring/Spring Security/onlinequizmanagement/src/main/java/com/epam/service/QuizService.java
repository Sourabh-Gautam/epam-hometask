package com.epam.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.entity.Quiz;
import com.epam.exception.ResourceNotFoundException;
import com.epam.repo.QuizRepository;

@Service
public class QuizService {
	
	@Autowired
	QuizRepository quizRepository;

	public Quiz createQuiz(Quiz quiz) {
		return quizRepository.save(quiz);
	}

	public List<Quiz> getAllQuiz() {
		System.out.println("Hii");
		return quizRepository.findAll();
	}
	
	public Optional<Quiz> getQuizById(int quizId) {
		return quizRepository.findById(quizId);
	}

	public int deleteQuizById(int quizId) {
		quizRepository.deleteById(quizId);
		return 1;
	}

	public Quiz renameQuiz(Quiz quiz) throws ResourceNotFoundException {
		return quizRepository.save(quiz);
	}
}
