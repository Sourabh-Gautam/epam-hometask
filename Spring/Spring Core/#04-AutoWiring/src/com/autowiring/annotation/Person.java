package com.autowiring.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Person {
	
	private Heart heart;
	
	@Autowired
	@Qualifier("brokenHeart")
	public void setHeart(Heart heart) {
		this.heart = heart;
		System.out.println("Setter called");
	}
	
	public void startPumping() {
		if(heart!=null) {
			heart.pump();
		}
		else {
			System.out.println("Heart is not pumping!");
		}
	}
}
