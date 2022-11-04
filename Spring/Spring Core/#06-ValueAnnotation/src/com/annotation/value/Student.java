package com.annotation.value;

import org.springframework.beans.factory.annotation.Value;

public class Student {
	private int rollno;
	private String name;
	private double fee;
	
	@Value("101")
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	
	@Value("Sourabh")
	public void setName(String name) {
		this.name = name;
	}
	
	@Value("500")
	public void setFee(double fee) {
		this.fee = fee;
	}
	
	@Override
	public String toString() {
		return "Student [rollno=" + rollno + ", name=" + name + ", fee=" + fee + "]";
	}
}
