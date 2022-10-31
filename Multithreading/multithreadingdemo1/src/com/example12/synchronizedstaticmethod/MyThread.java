package com.example12.synchronizedstaticmethod;

public class MyThread extends Thread {
	
	int number;
	
	public MyThread(String threadName, int number) {
		super(threadName);
		this.number = number;
	}
	
	@Override
	public void run() {
		MyTable.table(number);
	}
	
}
