package com.example03.usingrunnableinterface;

public class MyThread implements Runnable {
	
	@Override
	public void run() {
		System.out.println("MyThread is running !");
	}
	
}
