package com.epam.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.dto.AddressDTO;
import com.epam.dto.EmployeeDTO;
import com.epam.entity.Employee;
import com.epam.feignclient.AddressClient;
import com.epam.repo.EmployeeRepo;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepo employeeRepo;
	
	@Autowired
	private AddressClient addressClient;

	@Autowired
	private ModelMapper modelMapper;
	
	public EmployeeDTO getEmployeeById(int id) {
		
		Employee employee = employeeRepo.findById(id).get();
		
		EmployeeDTO employeeDTO = modelMapper.map(employee, EmployeeDTO.class);
		
		AddressDTO addressDTO = addressClient.getAddressByEmployeeId(id).getBody();		
		employeeDTO.setAddressDTO(addressDTO);
		
		return employeeDTO;
		
	}
	
}
