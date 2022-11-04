package com.epam;

import org.springframework.stereotype.Service;
@Service
public class ContractorService {
	CustomerService vendorService;
	
	CustomerService customerService;
	public ContractorService() {
		
	}
	
	public ContractorService(CustomerService vendorService, CustomerService customerService) {
		super();
		this.vendorService = vendorService;
		this.customerService = customerService;
	}

	public void getVendors() {
		System.out.println(vendorService.getContractors());
	}
	
	public void getCustomers() {
		System.out.println(customerService.getContractors());
	}
}
