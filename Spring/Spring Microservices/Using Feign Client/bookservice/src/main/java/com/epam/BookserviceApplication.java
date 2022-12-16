package com.epam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class BookserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookserviceApplication.class, args);
	}

}
