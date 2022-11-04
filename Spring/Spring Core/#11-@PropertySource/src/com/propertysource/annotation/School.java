package com.propertysource.annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class School {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(StudentConfig.class);
		Student stu = context.getBean("student", Student.class);
		System.out.println(stu);
		context.close();
	}
}