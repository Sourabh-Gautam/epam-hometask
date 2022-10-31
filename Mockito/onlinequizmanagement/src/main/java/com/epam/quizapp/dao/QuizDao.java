package com.epam.quizapp.dao;

import java.util.List;

import com.epam.quizapp.model.Quiz;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class QuizDao {

	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("my-persistence-unit");

	private static QuizDao quizDao;

	private QuizDao() {
	}

	public List<Quiz> getAllQuiz() {

		EntityManager manager = factory.createEntityManager();
		List<Quiz> quizList = manager.createQuery("from Quiz", Quiz.class).getResultList();
		manager.close();
		return quizList;

	}

	public List<Quiz> deleteQuiz(int quizId) {

		EntityManager manager = factory.createEntityManager();

		manager.getTransaction().begin();

		manager.remove(manager.find(Quiz.class, quizId));

		manager.getTransaction().commit();

		manager.close();

		return getAllQuiz();
	}

	public List<Quiz> renameQuiz(int quizId, String newQuizTitle) {
		
		EntityManager manager = factory.createEntityManager();

		Quiz quiz = manager.find(Quiz.class, quizId);
		
		if(quiz!=null) {
			manager.getTransaction().begin();
			quiz.setQuizTitle(newQuizTitle);
			manager.getTransaction().commit();
		}

		manager.close();
		
		return getAllQuiz();
		
	}

	public List<Quiz> addQuiz(Quiz quiz) {

		EntityManager manager = factory.createEntityManager();

		manager.getTransaction().begin();

		manager.persist(quiz);

		manager.getTransaction().commit();

		manager.close();

		return getAllQuiz();
	}

	public static QuizDao getInstance() {
		if (quizDao == null) {
			quizDao = new QuizDao();
		}
		return quizDao;
	}

}
