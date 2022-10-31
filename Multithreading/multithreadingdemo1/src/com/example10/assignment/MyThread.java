package com.example10.assignment;

public class MyThread extends Thread {
	
	public MyThread(String threadName) {
		super(threadName);
	}
	
	@Override
	public void run() {
		for(int i=0; i<5; i++) {
			System.out.println(getName()+" is running !");
			
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
