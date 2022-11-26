package com.epam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorldController {

	@RequestMapping("/hello")
	public String helloWorld() {
		return "helloworld";
	}
	
	@ResponseBody
	@GetMapping("/bye")
	public String bye() {
		return "Bye Bye !!";
	}
	
	@ResponseBody
	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome to website";
	}
}
