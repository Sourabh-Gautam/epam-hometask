package com.epam.quizapp.dao;

import java.util.List;
import java.util.stream.Collectors;

import com.epam.quizapp.database.QuizCollection;
import com.epam.quizapp.model.Quiz;

public class QuizDao {

	public static List<Quiz> getAllQuiz() {
		List<Quiz> quizList = QuizCollection.getInstance().getQuizList();
		return quizList;
	}

	public static List<Quiz> deleteQuiz(String quizId) {
		QuizCollection quizCollection = QuizCollection.getInstance();
		List<Quiz> quizList = quizCollection.getQuizList();

		quizList = quizList.stream().filter(e -> !e.getId().equals(quizId)).collect(Collectors.toList());
		
		quizCollection.setQuizList(quizList);
		// TODO Create a delete method inside db

		return quizList;
	}

	public static List<Quiz> renameQuiz(String quizId, String newQuizTitle) {
		QuizCollection quizCollection = QuizCollection.getInstance();
		List<Quiz> quizList = quizCollection.getQuizList();
		quizList = quizList.stream()
			.map(quiz -> {
				if(quiz.getId().equals(quizId)) {
					quiz.setQuizTitle(newQuizTitle);
				}
				return quiz;
			}).collect(Collectors.toList());
		return quizList;
	}

	public static List<Quiz> addQuiz(Quiz quiz) {
		QuizCollection quizCollection = QuizCollection.getInstance();
		quizCollection.insert(quiz);
		return quizCollection.getQuizList();
	}

}
