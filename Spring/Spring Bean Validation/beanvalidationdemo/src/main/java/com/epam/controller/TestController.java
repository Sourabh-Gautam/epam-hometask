package com.epam.controller;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.epam.model.User;

import jakarta.validation.Valid;

@RestController
public class TestController {

	@GetMapping("/test")
	public String test(@Valid @RequestBody User user, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			System.out.println("Finally");
		}
		return "done";
	}
	
}
