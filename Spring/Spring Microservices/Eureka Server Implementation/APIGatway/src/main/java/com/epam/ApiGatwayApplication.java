package com.epam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApiGatwayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatwayApplication.class, args);
	}
	
	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
	   return builder.routes()
	         .route(r -> r.path("/books/**")
	               .uri("lb://BOOKSERVICE"))
	         .route(r -> r.path("/users/**")
	               .uri("lb://USERSERVICE"))
	         .route(r -> r.path("/library/**")
	               .uri("lb://LIBRARYSERVICE"))
	         .build();
	}

}
