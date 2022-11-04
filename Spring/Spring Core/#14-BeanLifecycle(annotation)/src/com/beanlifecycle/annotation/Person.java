package com.beanlifecycle.annotation;

public class Person {

	public void init() {
		System.out.println("Entry - Take entry coin");
	}
	
	public void chilling() {
		System.out.println("Consuming alcohol, dancing and watching beauties");
	}
	
	
	public void destroy() {
		System.out.println("Exit - Give back entry coin");
	}
}
