package com.beanlifecycle.xml;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Bar {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("com/beanlifecycle/xml/config.xml");
		Person p = context.getBean("person", Person.class);
		p.chilling();
		context.close();
	}
}
