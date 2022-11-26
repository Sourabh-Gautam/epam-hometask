package com.epam.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {

	@GetMapping("greet/{name}")
	public String greet(@PathVariable String name) {
		return "Good night "+name;
	}
	
}
