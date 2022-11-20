package com.example04.givethreadname;

public class Main {

	public static void main(String[] args) {
		MyThread myThread = new MyThread();
		Thread thread = new Thread(myThread, "sourabh");
		thread.start();
		System.out.println("My Custom Thread Name : " + thread.getName());
		System.out.println("JVM Default Thread Name : "+Thread.currentThread().getName());
	}

}
