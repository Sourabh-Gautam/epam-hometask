package com.spring.object.setterinjection;

public class Person {
	private Air air;

	public void setAir(Air air) {
		this.air = air;
	}
	
	public void breath() {
		System.out.println("Person is Breathing - "+air);
	}
	
}

