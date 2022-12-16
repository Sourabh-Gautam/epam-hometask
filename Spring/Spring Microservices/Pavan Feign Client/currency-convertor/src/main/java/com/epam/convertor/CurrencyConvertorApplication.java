package com.epam.convertor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableFeignClients
public class CurrencyConvertorApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyConvertorApplication.class, args);
	}

	@Bean
	public RestTemplate getRest() {
		return new RestTemplate();
	}
	
}
