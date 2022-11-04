package com.paulspring.ioc1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mobile {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/paulspring/ioc1/config.xml");
		Sim sim = context.getBean("sim", Sim.class);
		sim.calling();
		sim.internet();
		((ClassPathXmlApplicationContext)context).close();
	}

}
