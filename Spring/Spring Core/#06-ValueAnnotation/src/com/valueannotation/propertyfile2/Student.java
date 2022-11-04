package com.valueannotation.propertyfile2;

import org.springframework.beans.factory.annotation.Value;

public class Student {
	@Value("${student.rollno}")
	private int rollno;
	
	@Value("${student.name}")
	private String name;
	
	@Value("${student.fee}")
	private double fee;
	
	@Override
	public String toString() {
		return "Student [rollno=" + rollno + ", name=" + name + ", fee=" + fee + "]";
	}
}
