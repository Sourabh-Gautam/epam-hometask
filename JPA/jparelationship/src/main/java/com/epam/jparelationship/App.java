package com.epam.jparelationship;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class App 
{
    public static void main( String[] args )
    {

//    	Quiz quiz = new Quiz();
//    	quiz.setQuizId(1);
//    	quiz.setQuizTitle("Solar System Quiz");
//    	
//    	Question q1 = new Question();
//    	q1.setQuestionId(1);
//    	q1.setQuestionStatement("question 1 ");
//    	q1.setOptionList(List.of(new Option(1, "option1", false, q1), new Option(2, "option2", false, q1)));
//    	q1.setQuiz(quiz);
//    	
//    	Question q2 = new Question();
//    	q2.setQuestionId(2);
//    	q2.setQuestionStatement("question 2 ");
//    	q2.setOptionList(List.of(new Option(3, "opt1", false, q2), new Option(4, "opt2", false, q2)));
//    	q2.setQuiz(quiz);
//    	
//    	Question q3 = new Question();
//    	q3.setQuestionId(3);
//    	q3.setQuestionStatement("question 3 ");
//    	q3.setOptionList(List.of(new Option(5, "opt1", false, q3), new Option(6, "option2", false, q3)));
//    	q3.setQuiz(quiz);
//    	
//    	List<Question> list = new ArrayList<>();
//    	list.add(q1);
//    	list.add(q2);
//    	list.add(q3);
//    	
//    	quiz.setQuestionList(list);
    	
    	DAO dao = new DAO();
//    	dao.insert(quiz);
    	EntityManagerFactory factory = Persistence.createEntityManagerFactory("my-persistence-unit");
		EntityManager manager = factory.createEntityManager();

		Question quiz = manager.find(Question.class, 1);

		manager.getTransaction().begin();
		manager.remove(quiz);
		manager.getTransaction().commit();

		manager.close();
		factory.close();
    	
//    	dao.delete(1);
    	
    }
}
