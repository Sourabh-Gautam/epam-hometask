package com.spring.aware;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(scopeName = "prototype")
public class Human {
	
	private double money;	

	public Human(double money) {
		super();
		this.money = money;
	}


	public void show() {
		System.out.println("Human have "+this.money+" money");
	}

}

