package com.spring.aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class Human implements ApplicationContextAware {
	
	ApplicationContext applicationContext;
	
	@Value(value = "3.14")
	private double money;	

	public void show() {
		System.out.println("Human have "+this.money+" money");
		applicationContext.getBean(Animal.class).show();
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
	
}

