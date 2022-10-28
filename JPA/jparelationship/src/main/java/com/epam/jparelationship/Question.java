package com.epam.jparelationship;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Question {
	@Id
	private int questionId;
	
	private String questionStatement;
	
	@OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
	List<Option> optionList;
	
	@ManyToOne
	private Quiz quiz;

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
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

	public Quiz getQuiz() {
		return quiz;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}

	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ", questionStatement=" + questionStatement + ", optionList="
				+ optionList + ", quiz=" + quiz + "]";
	}	

	
	
}
