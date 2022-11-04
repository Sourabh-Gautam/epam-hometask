package com.beanlifecycle.xml3;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Bar {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("com/beanlifecycle/xml3/config.xml");
		Girl girl = context.getBean("girl", Girl.class);
		girl.chilling();
		Boy boy = context.getBean("boy", Boy.class);
		boy.chilling();
		context.close();
	}
}
