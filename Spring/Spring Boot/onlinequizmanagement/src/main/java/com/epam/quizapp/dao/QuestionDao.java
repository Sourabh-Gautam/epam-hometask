package com.epam.quizapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;

import com.epam.quizapp.model.Question;
import com.epam.quizapp.model.Quiz;

@Repository
public class QuestionDao {
	
	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("my-persistence-unit");

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
	
}
