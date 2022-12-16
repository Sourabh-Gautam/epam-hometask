package com.epam.config;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class EmployeeAppConfig {
	
	@Value("${addressservice.base.url}")
	String addressBaseURL;
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	
}
