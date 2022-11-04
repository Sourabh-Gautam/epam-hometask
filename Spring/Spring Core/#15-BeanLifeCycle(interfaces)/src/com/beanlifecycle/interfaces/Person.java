package com.beanlifecycle.interfaces;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Person implements DisposableBean, InitializingBean {
	
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Entry - Take entry coin");
	}
	
	public void chilling() {
		System.out.println("Consuming alcohol, dancing and watching beauties");
	}
	
	@Override
	public void destroy() {
		System.out.println("Exit - Give back entry coin");
	}

}
