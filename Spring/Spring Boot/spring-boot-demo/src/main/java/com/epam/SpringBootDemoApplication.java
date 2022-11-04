package com.epam;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;



@SpringBootApplication
public class SpringBootDemoApplication {

	public static void main(String[] args) {
		
		
		Logger logger = LogManager.getLogger();
		
		ApplicationContext context = SpringApplication.run(SpringBootDemoApplication.class, args);

		Greeting greeting = context.getBean(Greeting.class);

		logger.info(greeting.sayHello("Abhinav"));
	}

}
