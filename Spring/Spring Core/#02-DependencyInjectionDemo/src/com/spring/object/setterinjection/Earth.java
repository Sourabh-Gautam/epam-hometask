package com.spring.object.setterinjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Earth {
	public static void main(String []args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/object/setterinjection/config.xml");
		Person p = context.getBean("person", Person.class);
		p.breath();
		((ClassPathXmlApplicationContext)context).close();
	}
}