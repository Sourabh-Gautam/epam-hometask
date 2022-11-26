package com.epam;

import java.io.File;
import java.io.IOException;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;

import com.epam.model.Customer;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class ReadingjsonApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReadingjsonApplication.class, args);
	}
	
    @Bean
    CommandLineRunner runner() {
        return args -> {
        	ObjectMapper mapper = new ObjectMapper();

        	// read JSON file and map/convert to java POJO
        	try {
        		File classPathResource = new ClassPathResource("customers.json").getFile();
        		System.out.println(classPathResource);
//        	    Customer someClassObject = mapper.readValue(classPathResource), Customer.class);
//        	    System.out.println(someClassObject);
        	} catch (IOException e) {
        	    e.printStackTrace();
        	}
        };
    }

}
