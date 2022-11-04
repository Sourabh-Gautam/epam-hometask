package com.component.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class School {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/component/annotation/config.xml");
		System.out.println("Object created ");
		SchoolStudent stu = context.getBean("schoolStudent", SchoolStudent.class);
		System.out.println(stu);
		((ClassPathXmlApplicationContext)context).close();
	}

}
