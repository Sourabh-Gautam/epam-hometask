package com.epam.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.epam.dto.AddressDTO;

@FeignClient(name = "address-service", url = "http://localhost:8080", path = "/address-app/api")
public interface AddressClient {

	@GetMapping("/address/{employeeId}")
	public ResponseEntity<AddressDTO> getAddressByEmployeeId(@PathVariable("employeeId") int id);
	
}
