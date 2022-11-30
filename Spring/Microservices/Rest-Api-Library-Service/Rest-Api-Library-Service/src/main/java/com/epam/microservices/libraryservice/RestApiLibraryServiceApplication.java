package com.epam.microservices.libraryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class RestApiLibraryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestApiLibraryServiceApplication.class, args);
	}

	@Bean
	public WebClient getUserWebClient(WebClient.Builder webClientBuilder) {
		return webClientBuilder
				.clone()
				.baseUrl("http://localhost:8080/users")
				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.build();
	}

	@Bean
	public WebClient getBookWebClient(WebClient.Builder webClientBuilder) {
		return webClientBuilder
				.clone()
				.baseUrl("http://localhost:9000/books")
				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.build();
	}

}
