package com.paulspring.ioc1;

public class Airtel implements Sim {

	@Override
	public void calling() {
		System.out.println("Calling from airtel");
	}

	@Override
	public void internet() {
		System.out.println("Internet surfing from airtel");
	}

}
