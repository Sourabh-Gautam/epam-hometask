package com.epam;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
@Service(value = "customerService")
public class CustomerServiceImpl implements CustomerService{
	
	public List<Customer> getContractors(){
		return Arrays.asList(new Customer("komal","java"),new Customer("sneka","sql"));
	}
}
