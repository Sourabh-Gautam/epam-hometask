package com.primary.annotation;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class BlackPen implements Pen {

	@Override
	public void writing(int rollno) {
		System.out.println("Writing rollno with BlackPen - "+rollno);
	}

}
