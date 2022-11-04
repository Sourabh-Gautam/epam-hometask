package com.autowiring.annotation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Body {

	public static void main(String[] args) {
		String p = "com/autowiring/annotation/config.xml";
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(p);
		Person person = context.getBean("person", Person.class);
		person.startPumping();
		context.close();
	}

}
