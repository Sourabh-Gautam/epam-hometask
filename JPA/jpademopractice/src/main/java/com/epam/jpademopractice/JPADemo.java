package com.epam.jpademopractice;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPADemo {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("my-persistence-unit");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		
		Student student = new Student(4, "VI", "Divyam");
		
		manager.persist(student);
		
		manager.getTransaction().commit();

		manager.close();
	}

}
