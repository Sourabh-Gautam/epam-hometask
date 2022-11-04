package com.autowiring.xml;

public class Person {
	private Heart heart;

	public Person(Heart heart) {
		super();
		this.heart = heart;
	}
	
//	public void setHeart(Heart heart) {
//		System.out.println("setter");
//		this.heart = heart;
//	}
	
	public void startPumping() {
		if(heart!=null) {
			heart.pump();
		}
		else {
			System.out.println("Heart is not pumping!");
		}
	}
}
