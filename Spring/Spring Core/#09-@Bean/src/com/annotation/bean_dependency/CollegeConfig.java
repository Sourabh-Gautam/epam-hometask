package com.annotation.bean_dependency;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CollegeConfig {
		
	@Bean
	public Principal principalBean() {
		return new Principal();
	}
	
	@Bean
	public College collegeBean() {
		College clg = new College();
		clg.setPrincipal(this.principalBean());
		return clg;
	}
	
}
