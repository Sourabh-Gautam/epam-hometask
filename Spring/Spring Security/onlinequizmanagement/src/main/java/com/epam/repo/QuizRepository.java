package com.epam.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.epam.entity.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Integer> {
	
}
