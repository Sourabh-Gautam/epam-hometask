package com.epam.quizapp.dao;

import java.util.Optional;

import com.epam.quizapp.model.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class UserDao {
EntityManagerFactory factory = Persistence.createEntityManagerFactory("my-persistence-unit");
	
	private static UserDao userDao;
	
	private UserDao() {
	}
	
	public boolean registerUser(User user) {
		
		if(getUser(user)==null) {
			
			EntityManager manager = factory.createEntityManager();
			manager.getTransaction().begin();
			manager.persist(user);
			manager.getTransaction().commit();
			manager.close();
			
			return true;
		}
		return false;
	}
	
	public User getUser(User user) {

		EntityManager manager = factory.createEntityManager();
		TypedQuery<User> qry = manager.createQuery("from User u where u.username = :username and u.password = :password", User.class);
		qry.setParameter("username", user.getUsername());
		qry.setParameter("password", user.getPassword());
		Optional<User> optional = Optional.empty();
		if(!qry.getResultList().isEmpty()) {
			optional = Optional.ofNullable(qry.getResultList().get(0));
		}
		manager.close();
		return optional.orElse(null);
	
	}
	
	public static UserDao getInstance() {
		if(userDao==null) {
			userDao = new UserDao();
		}
		return userDao;
	}
}
