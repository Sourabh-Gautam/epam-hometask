package com.epam.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.epam.entity.Student;

@RestController
public class StudentController {
	
	@GetMapping("/student")
	public Student getStudent() {
		return new Student(1, "Sourabh", "Gautam");
	}
	
	@GetMapping("/students")
	public List<Student> getAllStudent() {
		return List.of(
				new Student(1, "Sourabh", "Gautam"),
				new Student(1, "Divyam", "Sethi")
				);
	}
	
	@GetMapping("/student/{firstname}/{lastname}")
	public Student getStudent(@PathVariable(name = "firstname") String firstName, @PathVariable(name = "lastname") String lastName) {
		return new Student(1, firstName, lastName);
	}
	
}
