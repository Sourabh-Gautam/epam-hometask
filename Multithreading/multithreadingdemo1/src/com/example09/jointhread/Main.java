package com.example09.jointhread;

public class Main {

	public static void main(String[] args) {
		System.out.println("Main thread is running");
		
		MyThread myThread = new MyThread();
		myThread.setDaemon(true);
		myThread.start();
		
		try {
			Thread.sleep(2000);
			myThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Main thread is stopped");
	}

}
