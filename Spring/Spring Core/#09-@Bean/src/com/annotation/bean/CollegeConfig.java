package com.annotation.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CollegeConfig {
	
	@Bean(name= "dude")
	public College collegeBean() {
		return new College();
	}
	
}
