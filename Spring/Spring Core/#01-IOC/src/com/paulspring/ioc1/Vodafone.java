package com.paulspring.ioc1;

public class Vodafone implements Sim {

	@Override
	public void calling() {
		System.out.println("Calling from vodafone");
	}

	@Override
	public void internet() {
		System.out.println("Internet surfing from vodafone");
	}

}
