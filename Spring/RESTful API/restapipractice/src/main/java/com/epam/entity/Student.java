package com.epam.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {

	private long id;
	
	private String firstName;
	
	private String lastName;
	
}
