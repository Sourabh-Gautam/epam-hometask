package com.epam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.epam.dto.EmployeeDTO;
import com.epam.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<EmployeeDTO> getEmployee(@PathVariable("id") int id) {
		
		EmployeeDTO employee = employeeService.getEmployeeById(id);
		return ResponseEntity.status(HttpStatus.OK).body(employee);
		
	}
	
}
