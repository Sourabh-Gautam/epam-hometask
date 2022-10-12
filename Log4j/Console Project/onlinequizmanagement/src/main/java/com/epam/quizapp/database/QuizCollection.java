package com.epam.quizapp.database;

import java.util.ArrayList;
import java.util.List;

import com.epam.quizapp.model.Option;
import com.epam.quizapp.model.Question;
import com.epam.quizapp.model.Quiz;

public class QuizCollection {
	private static List<Quiz> quizList = new ArrayList<>();

	static{
		
		List<Option> optionList1 = new ArrayList<>();
				optionList1.add(new Option("A", "Saturn", false));
				optionList1.add(new Option("B", "Jupiter", true));
				optionList1.add(new Option("C", "Earth", false) );
				optionList1.add(new Option("D", "Mars", false));
				
		Question question1 = new Question("1", "What is the largest planet in our solar system?", optionList1);
		
		List<Option> optionList2 = new ArrayList<>();
		optionList2.add(new Option("A", "Eight", true));
		optionList2.add(new Option("B", "Nine", false));
		optionList2.add(new Option("C", "Ten", false));
		optionList2.add(new Option("D", "Eleven", false));
		
		Question question2 = new Question("2", "How many planets are there in our solar system?", optionList2);
		
		List<Option> optionList3 = new ArrayList<>();
		optionList3.add(new Option("A", "Saturn", false));
		optionList3.add(new Option("B", "Mercury", true));
		optionList3.add(new Option("C", "Earth", false));
		optionList3.add(new Option("D", "Mars", false));
		
		Question question3 = new Question("3", "Which is smallest planet in our solar system?", optionList3);
		
		ArrayList<Question> questionList = new ArrayList<>();
		questionList.add(question1);
		questionList.add(question2);
		questionList.add(question3);
		
		Quiz quiz1 = new Quiz("1", "Solar System Quiz", questionList);
		quizList.add(quiz1);
		
		Quiz quiz2 = new Quiz("2", "GK Quiz", null);
		quizList.add(quiz2);
		
		Quiz quiz3 = new Quiz("3", "Hindi Quiz", null);
		quizList.add(quiz3);
		
		Quiz quiz4 = new Quiz("4", "Current Affair Quiz", null);
		quizList.add(quiz4);
		
		Quiz quiz5 = new Quiz("5", "Math Quiz", null);
		quizList.add(quiz5);
	}
	
	public void insert(Quiz quiz) {
		quizList.add(quiz);
	}

	public List<Quiz> getQuizList() {
		return quizList;
	}
	
	public Quiz getQuiz(String quizId) {
		return quizList.stream().filter(e -> e.getId().equals(quizId)).findFirst().orElse(null);
	}
	
	public void setQuizList(List<Quiz> quizList) {
		QuizCollection.quizList = quizList;
	}
	
	public static QuizCollection getInstance() {
		return new QuizCollection();
	}
}
