package com.annotation.bean_dependency;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(CollegeConfig.class);
		College stu = context.getBean("collegeBean", College.class);
		stu.helloPrincipal();
		((ClassPathXmlApplicationContext)context).close();
	}
}
