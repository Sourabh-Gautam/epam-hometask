package com.valueannotation.propertyfile2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class School {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/valueannotation/propertyfile2/config.xml");
		Student stu = context.getBean("stu", Student.class);
		System.out.println(stu);
		((ClassPathXmlApplicationContext)context).close();
	}

}
