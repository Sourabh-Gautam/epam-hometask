package com.epam.quizapp.dao;

import java.util.List;
import java.util.stream.Collectors;

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
		
		manager.getTransaction().begin();
		Quiz quiz = manager.find(Quiz.class, quizId);
		manager.getTransaction().commit();
		
		manager.close();
		
		return quiz.getQuestionList();
	}

	public List<Question> deleteQuestion(int quizId, int questionId) {
		
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();

		Question question = manager.find(Question.class, questionId);
		
		manager.remove(question);
//		Query query = manager.createQuery("delete from Question where id = :questionId");
		
//		query.setParameter("questionId", questionId);
		manager.getTransaction().commit();
		
		manager.close();
		
		return getQuestionList(quizId);
	}
	
	public List<Question> addQuestion(int quizId, Question question) {
		
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		Quiz quiz = manager.find(Quiz.class, quizId);
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
