package com.spring.literal.constructorinjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Earth {
	public static void main(String []args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/literal/constructorinjection/config.xml");
		Person p = context.getBean("person", Person.class);
		p.show();
		((ClassPathXmlApplicationContext)context).close();
	}
}