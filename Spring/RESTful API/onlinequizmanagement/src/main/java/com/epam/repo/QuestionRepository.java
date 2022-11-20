package com.epam.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.epam.entity.Question;

public interface QuestionRepository extends JpaRepository<Question, Integer> {

	@Query("from Question q where q.quizId = ?1")
	List<Question> findQuestionsByQuizId(int quizId);

}
