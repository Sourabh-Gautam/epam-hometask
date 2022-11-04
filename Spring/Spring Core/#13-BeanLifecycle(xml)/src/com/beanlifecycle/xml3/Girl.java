package com.beanlifecycle.xml3;

public class Girl {
	public void init() {
		System.out.println("Girl Entry - Take entry coin");
	}
	
	public void chilling() {
		System.out.println("Girl - Consuming alcohol, dancing and watching handsomes");
	}
	
	public void destroy() {
		System.out.println("Girl Exit - Give back entry coin");
	}
}
