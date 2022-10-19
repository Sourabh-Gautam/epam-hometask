package com.epam.quizapp.model;

import java.util.List;

public class Quiz {

	private String id;
	private String quizTitle;
	private List<Question> questionList;
	
	public Quiz() {
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getQuizTitle() {
		return quizTitle;
	}

	public void setQuizTitle(String quizTitle) {
		this.quizTitle = quizTitle;
	}

	public List<Question> getQuestionList() {
		return questionList;
	}

	public void setQuestionList(List<Question> questionList) {
		this.questionList = questionList;
	}

	public Quiz(String id, String quizTitle, List<Question> questionList) {
		super();
		this.id = id;
		this.quizTitle = quizTitle;
		this.questionList = questionList;
	}

	@Override
	public String toString() {
		return "Quiz [id=" + id + ", quizTitle=" + quizTitle + ", questionList=" + questionList + "]";
	}

}
