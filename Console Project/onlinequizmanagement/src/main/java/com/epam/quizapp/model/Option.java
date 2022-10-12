package com.epam.quizapp.model;

public class Option {

	private String id;
	private String optionName;
	private boolean isCorrect;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public Option(String id, String optionName, boolean isCorrect) {
		super();
		this.id = id;
		this.optionName = optionName;
		this.isCorrect = isCorrect;
	}

	@Override
	public String toString() {
		return "Option [id=" + id + ", optionName=" + optionName + ", isCorrect=" + isCorrect + "]";
	}

}
