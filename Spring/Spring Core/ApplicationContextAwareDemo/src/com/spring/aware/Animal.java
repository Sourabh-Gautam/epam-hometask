package com.spring.aware;

import org.springframework.stereotype.Component;

@Component
public class Animal {

	private double money;	

	public void show() {
		System.out.println("Animal have "+this.money+" money");
	}
}
