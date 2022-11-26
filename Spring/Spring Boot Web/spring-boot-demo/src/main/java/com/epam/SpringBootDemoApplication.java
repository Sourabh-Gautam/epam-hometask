package com.epam;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;



@SpringBootApplication
@Import(SecurityConfiguration.class)
public class SpringBootDemoApplication implements CommandLineRunner {

	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AuthGroupRepository authGroupRepository;
	
	public static void main(String[] args) {
		
		
		Logger logger = LogManager.getLogger();
		
		ApplicationContext context = SpringApplication.run(SpringBootDemoApplication.class, args);

		Greeting greeting = context.getBean(Greeting.class);

		logger.info(greeting.sayHello("Abhinav"));
	}

	@Override
	public void run(String... args) throws Exception {
		
//		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//		User user1 = new User();
//		user1.setUsername("pavan");
//		user1.setPassword(passwordEncoder.encode("password"));
//
//		User user2 = new User();
//		user2.setUsername("Divyam");
//		user2.setPassword(passwordEncoder.encode("password"));
//		
//		userRepository.save(user1);
//		userRepository.save(user2);
//
//		AuthGroup authGroup = new AuthGroup();
//		authGroup.setUsername("pavan");
//		authGroup.setAuthGroup("ADMIN");
//
//		AuthGroup authGroup1 = new AuthGroup();
//		authGroup1.setUsername("Divyam");
//		authGroup1.setAuthGroup("USER");
//
//		authGroupRepository.save(authGroup);
//		authGroupRepository.save(authGroup1);
	}

}
