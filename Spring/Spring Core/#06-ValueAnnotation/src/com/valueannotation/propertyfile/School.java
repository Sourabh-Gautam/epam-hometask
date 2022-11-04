package com.valueannotation.propertyfile;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class School {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/valueannotation/propertyfile/config.xml");
		Student stu = context.getBean("stu", Student.class);
		System.out.println(stu);
		((ClassPathXmlApplicationContext)context).close();
	}

}
