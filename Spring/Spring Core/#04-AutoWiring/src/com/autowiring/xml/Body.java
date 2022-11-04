package com.autowiring.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Body {

	public static void main(String[] args) {
		String p = "com/autowiring/xml/config.xml";
		ApplicationContext context = new ClassPathXmlApplicationContext(p);
		Person person = context.getBean("person", Person.class);
		person.startPumping();
		((ClassPathXmlApplicationContext)context).close();
	}

}
