package com.spring.sorting;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApp {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/sorting/config.xml");
		SortMyArray sma = context.getBean("sma", SortMyArray.class);
		sma.sortArray();
		((ClassPathXmlApplicationContext)context).close();
	}

}
