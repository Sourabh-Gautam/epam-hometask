package com.epam;

import org.springframework.stereotype.Component;

@Component
public class Greeting {

	
	public String sayHello(String message) {
		return "Hi "+ message;
	}
}
