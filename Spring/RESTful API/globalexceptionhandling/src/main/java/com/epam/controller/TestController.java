package com.epam.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epam.exception.BlankFieldException;
import com.epam.exception.EmptyFieldException;
import com.epam.model.User;

@RestController
@RequestMapping("/test")
public class TestController {
	
	@GetMapping("/hello")
	public void hello(){
		System.out.println("hhii");
	}
	
	@GetMapping("/getuser")
	public ResponseEntity<User> getByUserName(@RequestBody User user) throws EmptyFieldException, BlankFieldException {
		if(user.getUsername().isEmpty()) {
			throw new EmptyFieldException("The username is empty. Please provide some value.");
		}
		
		if(user.getUsername().isBlank()) {
			throw new BlankFieldException("The username is blank. Please provide some value.");
		}
		
		return ResponseEntity.ok().body(user);
		
	}
	
}