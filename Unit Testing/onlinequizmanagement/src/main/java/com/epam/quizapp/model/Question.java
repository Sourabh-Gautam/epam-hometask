package com.epam.quizapp.model;

import java.util.List;

public class Question {

	private String id;
	private String questionStatement;
	private List<Option> optionList;

	public Question(String id, String questionStatement, List<Option> optionList) {
		super();
		this.id = id;
		this.questionStatement = questionStatement;
		this.optionList = optionList;
	}

	public Question() {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getQuestionStatement() {
		return questionStatement;
	}

	public void setQuestionStatement(String questionStatement) {
		this.questionStatement = questionStatement;
	}

	public List<Option> getOptionList() {
		return optionList;
	}

	public void setOptionList(List<Option> optionList) {
		this.optionList = optionList;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", questionStatement=" + questionStatement + ", optionList=" + optionList + "]";
	}

}
