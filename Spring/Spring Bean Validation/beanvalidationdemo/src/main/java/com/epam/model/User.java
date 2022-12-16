package com.epam.model;

import jakarta.validation.constraints.NotBlank;

public class User {
	@NotBlank
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
