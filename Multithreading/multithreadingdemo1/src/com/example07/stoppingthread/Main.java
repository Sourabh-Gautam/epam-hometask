package com.example07.stoppingthread;

public class Main {

	public static void main(String[] args) {
		System.out.println("Main thread is running");
		
		MyThread myThread = new MyThread();
		myThread.start();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		myThread.doStop();
		
		System.out.println("Main thread is stopped");
	}

}
