package com.propertysource.annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Student {
	private int rollno;
	private String name;
	private double fee;
	
	@Value("${student.rollno}")
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	
	@Value("${student.name}")
	public void setName(String name) {
		this.name = name;
	}
	
	@Value("${student.fee}")
	public void setFee(double fee) {
		this.fee = fee;
	}
	
	@Override
	public String toString() {
		return "Student [rollno=" + rollno + ", name=" + name + ", fee=" + fee + "]";
	}
}
