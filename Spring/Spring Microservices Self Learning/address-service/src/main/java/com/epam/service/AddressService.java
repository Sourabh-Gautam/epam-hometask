package com.epam.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.dto.AddressDTO;
import com.epam.entity.Address;
import com.epam.repo.AddressRepo;

@Service
public class AddressService {
	
	@Autowired
	private AddressRepo addressRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	public AddressDTO findAddressByEmployeeId(int employeeId) {
		
		Address address = addressRepo.findAddressByEmployeeId(employeeId);
		return modelMapper.map(address, AddressDTO.class);
		
		
	}
	
}
