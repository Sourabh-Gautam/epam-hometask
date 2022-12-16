package com.epam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class LibraryserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryserviceApplication.class, args);
	}
	
}