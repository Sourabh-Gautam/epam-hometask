package com.beanlifecycle.xml3;

public class Boy {
	public void init() {
		System.out.println("Boy Entry - Take entry coin");
	}
	
	public void chilling() {
		System.out.println("Boy - Consuming alcohol, dancing and watching beauties");
	}
	
	public void destroy() {
		System.out.println("Boy Exit - Give back entry coin");
	}
}
