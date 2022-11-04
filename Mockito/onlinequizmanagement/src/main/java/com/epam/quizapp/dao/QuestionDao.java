package com.epam.quizapp.dao;

import java.util.List;

import com.epam.quizapp.model.Question;
import com.epam.quizapp.model.Quiz;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class QuestionDao {
	
	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("my-persistence-unit");
	
	private static QuestionDao questionDao;
	
	private QuestionDao() {
	}

	public List<Question> getQuestionList(int quizId) {
		
		EntityManager manager = factory.createEntityManager();
		Quiz quiz = manager.find(Quiz.class, quizId);
		manager.close();
		
		return quiz.getQuestionList();
	}

	public List<Question> deleteQuestion(int quizId, int questionId) {
		
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();

		Question question = manager.find(Question.class, questionId);
		
		if(question != null) {
			manager.remove(question);
		}

		manager.getTransaction().commit();
		
		manager.close();
		
		return getQuestionList(quizId);
	}
	
	public List<Question> addQuestion(int quizId, Question question) {
		
		EntityManager manager = factory.createEntityManager();
		
		Quiz quiz = manager.find(Quiz.class, quizId);
		manager.getTransaction().begin();
		question.setQuiz(quiz);
		List<Question> questionList = quiz.getQuestionList();
		questionList.add(question);
		quiz.setQuestionList(questionList);
		
		manager.getTransaction().commit();
		
		manager.close();
		return getQuestionList(quizId);
	}
	
	public static QuestionDao getInstance() {
		if(questionDao==null) {
			questionDao = new QuestionDao();
		}
		return questionDao;
	}

}
