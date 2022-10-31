package com.example09.jointhread;

public class MyThread extends Thread {

	@Override
	public void run() {
		for(int i=0; i<5; i++) {
			System.out.println("Custom Thread Running");
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Custom Thread Stopped");
	}
	
}
