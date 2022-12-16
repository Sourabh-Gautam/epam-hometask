package com.epam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;

import com.epam.dto.AddressDTO;
import com.epam.service.AddressService;

@RestController
public class AddressController {
	
	@Autowired
	private AddressService addressService;

	@GetMapping("/address/{employeeId}")
	public ResponseEntity<AddressDTO> getAddressByEmployeeId(@PathVariable("employeeId") int id) {
		
		System.out.println("Address Controller");
		
		AddressDTO addressDTO = addressService.findAddressByEmployeeId(id);
		
		return ResponseEntity.status(HttpStatus.OK).body(addressDTO);
	}
	
}
