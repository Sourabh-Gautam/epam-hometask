package com.spring.object.constructorinjection;

public class Person {
	
	private Air air;

	public Person(Air air) {
		this.air = air;
	}

	public Air getAir() {
		return air;
	}

}

