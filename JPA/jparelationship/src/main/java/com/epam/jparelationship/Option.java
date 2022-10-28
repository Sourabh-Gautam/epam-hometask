package com.epam.jparelationship;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "options")
public class Option {
	
	@Id
	int optionId;
	
	String optionName;
	
	boolean isCorrect;
	
	@ManyToOne
	Question question;

	public Option() {
		
	}
	
	public Option(int optionId, String optionName, boolean isCorrect, Question question) {
		super();
		this.optionId = optionId;
		this.optionName = optionName;
		this.isCorrect = isCorrect;
		this.question = question;
	}

	public int getOptionId() {
		return optionId;
	}

	public void setOptionId(int optionId) {
		this.optionId = optionId;
	}

	public String getOptionName() {
		return optionName;
	}

	public void setOptionName(String optionName) {
		this.optionName = optionName;
	}

	public boolean isCorrect() {
		return isCorrect;
	}

	public void setCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	@Override
	public String toString() {
		return "Option [optionId=" + optionId + ", optionName=" + optionName + ", isCorrect=" + isCorrect
				+ ", question=" + question + "]";
	}

	
}
