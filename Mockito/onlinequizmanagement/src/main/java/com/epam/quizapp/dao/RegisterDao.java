package com.epam.quizapp.dao;

import java.util.Optional;

import com.epam.quizapp.model.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class RegisterDao {
	
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("my-persistence-unit");
	
	private static RegisterDao registerDao;
	
	private RegisterDao() {
	}
	
	public Optional<User> registerUser(User user) {
		
		Optional<User> userOptional = Optional.empty();
		if(LoginDao.getInstance().getUser(user)==null) {
			
			EntityManager manager = factory.createEntityManager();
			manager.getTransaction().begin();
			manager.persist(user);
			manager.getTransaction().commit();
			manager.close();
			
			userOptional = Optional.ofNullable(user);
		}
		return userOptional;
	}
	
	public static RegisterDao getInstance() {
		if(registerDao==null) {
			registerDao = new RegisterDao();
		}
		return registerDao;
	}
}
