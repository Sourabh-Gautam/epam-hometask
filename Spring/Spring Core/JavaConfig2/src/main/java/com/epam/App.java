package com.epam;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class App {
	

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext(App.class);
		ContractorService contractorService= applicationContext.getBean(ContractorService.class);
		contractorService.getCustomers();
		contractorService.getVendors();
		applicationContext.close();
//		CustomerService customerService=new CustomerService();
//		System.out.println(customerService.getCustomers());
	}

}
