package com.primary.annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class School {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(StudentConfig.class);
		Student stu = context.getBean("student", Student.class);
		stu.startWriting();
		context.close();
	}

}
