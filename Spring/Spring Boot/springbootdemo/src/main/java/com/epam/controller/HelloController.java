package com.epam.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@Value("${welcome.message}")
	private String welcomeMessage;
	
//	Step 1 :
	
//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public String helloWorld() {
//		return "Hello World !";
//	}
	
//	Step 2 :
	
	@GetMapping("/")
	public String helloWorld() {
		return welcomeMessage;
	}
}
