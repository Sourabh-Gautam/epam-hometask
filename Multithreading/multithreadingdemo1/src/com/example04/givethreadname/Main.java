package com.example04.givethreadname;

public class Main {

	public static void main(String[] args) {
		MyThread myThread = new MyThread();
		Thread thread = new Thread(myThread, "mythread");
		thread.start();
		System.out.println("My Custom Thread : " + thread.getName());
		System.out.println("JVM Default Thread : "+Thread.currentThread().getName());
	}

}
