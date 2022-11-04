package com.spring.literal.constructorinjection;

public class Person {
	
	private double money;
	
	public Person(int money) {
		this.money = money*5;
	}
	
	public Person(double money) {
		this.money = money;
	}
	

	public void show() {
		System.out.println(this.money);
	}
	
}

