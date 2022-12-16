package com.epam.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.epam.dto.AddressDTO;
import com.epam.dto.EmployeeDTO;
import com.epam.entity.Employee;
import com.epam.repo.EmployeeRepo;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepo employeeRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private WebClient webClient;

//	@Autowired
	private RestTemplate restTemplate;
	
	public EmployeeService(@Value("${addressservice.base.url}") String addressBaseURL, RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.rootUri(addressBaseURL).build();
	}
	
	public EmployeeDTO getEmployeeById(int id) {
		
		Employee employee = employeeRepo.findById(id).get();
		
		EmployeeDTO employeeDTO = modelMapper.map(employee, EmployeeDTO.class);
		
		AddressDTO addressDTO = gettingAddressThroughWebClient(id);		
		employeeDTO.setAddressDTO(addressDTO);
		
		return employeeDTO;
		
	}
	
	public AddressDTO gettingAddressThroughRestTemplate(int id) {
		return restTemplate.getForObject("/address/{id}", AddressDTO.class, id);
	}
	
	public AddressDTO gettingAddressThroughWebClient(int id) {
		return webClient.get().uri("/address/"+id).retrieve().bodyToMono(AddressDTO.class).block();
	}
	
}
