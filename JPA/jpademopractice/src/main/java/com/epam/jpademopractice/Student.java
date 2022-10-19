package com.epam.jpademopractice;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student {
	@Id
	private int rollno;
	
	@Column(name = "class")
	private String className;
	
	private String name;
	
	public Student(int rollno, String className, String name) {
		super();
		this.rollno = rollno;
		this.className = className;
		this.name = name;
	}
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Student [rollno=" + rollno + ", className=" + className + ", name=" + name + "]";
	}
	
}
