package com.spring.object.constructorinjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Earth {
	public static void main(String []args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/object/constructorinjection/config.xml");
		Person p = context.getBean("person", Person.class);
		System.out.println(p.getAir());
		((ClassPathXmlApplicationContext)context).close();
	}
}