package com.spring.literal.setterinjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Earth {
	public static void main(String []args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/literal/setterinjection/config.xml");
		Person p = context.getBean("person", Person.class);
		System.out.println(p.getMoney());
		((ClassPathXmlApplicationContext)context).close();
	}
}