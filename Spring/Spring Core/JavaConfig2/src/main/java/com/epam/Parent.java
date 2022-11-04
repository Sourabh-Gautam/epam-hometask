package com.epam;

public class Parent {
	public Object m1()  {
		return null;
	}
}
 class Child extends Parent{
	@Override
	public String m1() throws StringIndexOutOfBoundsException {
		return null;
	}
 }
