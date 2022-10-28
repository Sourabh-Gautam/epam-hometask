package com.epam.jparelationship;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DAO {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("my-persistence-unit");

	public void insert(Quiz quiz) {

		EntityManager manager = factory.createEntityManager();

		manager.getTransaction().begin();

		manager.persist(quiz);
	
		manager.getTransaction().commit();

		manager.close();

	}
	
	public Quiz delete(int quizId) {
		EntityManager manager = factory.createEntityManager();

		Quiz quiz = manager.find(Quiz.class, quizId);

		manager.getTransaction().begin();
		manager.remove(quiz);
		manager.getTransaction().commit();

		manager.close();
		return quiz;
	}

}
