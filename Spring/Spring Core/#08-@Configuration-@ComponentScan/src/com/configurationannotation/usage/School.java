package com.configurationannotation.usage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class School {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(StudentConfig.class);
		System.out.println("Object created ");
		Student stu = context.getBean("student", Student.class);
		System.out.println(stu);
		((ClassPathXmlApplicationContext)context).close();
	}

}
