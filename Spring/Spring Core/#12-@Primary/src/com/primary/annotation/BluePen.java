package com.primary.annotation;

import org.springframework.stereotype.Component;

@Component
public class BluePen implements Pen {

	@Override
	public void writing(int rollno) {
		System.out.println("Writing rollno with BluePen - "+rollno);
	}

}
