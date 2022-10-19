package com.epam.quizapp.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.epam.quizapp.database.QuizCollection;
import com.epam.quizapp.model.Question;
import com.epam.quizapp.model.Quiz;

public class QuestionDao {
	
	private QuestionDao() {
	}

	public static List<Question> getQuestionList(String quizId) {
		List<Quiz> quizList = QuizCollection.getInstance().getQuizList();
		for (Quiz quiz : quizList) {
			if (quiz.getId().equals(quizId)) {
				return quiz.getQuestionList();
			}
		}
		return new ArrayList<>();
	}

	public static List<Question> deleteQuestion(String quizId, String questionId) {
		
		List<Quiz> quizList = QuizCollection.getInstance().getQuizList();
		quizList = quizList.stream().map(quiz -> {
			if (quiz.getId().equals(quizId)) {
				quiz.setQuestionList(quiz.getQuestionList().stream().filter(e -> !e.getId().equals(questionId))
						.collect(Collectors.toList()));
			}
			return quiz;
		}).collect(Collectors.toList());
		QuizCollection.setQuizList(quizList);
		return getQuestionList(quizId);
	}
	
	public static List<Question> addQuestion(String quizId, Question question) {
		QuizCollection quizCollection = QuizCollection.getInstance();
		Quiz quiz = quizCollection.getQuiz(quizId);
		Optional<List<Question>> optionalQuestionList = Optional.ofNullable(quiz.getQuestionList());
		List<Question> questionList = new ArrayList<>();
		if(optionalQuestionList.isPresent()) {
			questionList = optionalQuestionList.get();
			String questionId = String.valueOf(Integer.parseInt(questionList.get(questionList.size()-1).getId())+1);
			question.setId(questionId);
		}
		questionList.add(question);
		quiz.setQuestionList(questionList);
		QuizDao.deleteQuiz(quizId);
		quizCollection.insert(quiz);
		return questionList;
	}

}
