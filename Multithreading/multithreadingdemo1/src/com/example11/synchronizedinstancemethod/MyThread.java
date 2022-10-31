package com.example11.synchronizedinstancemethod;

public class MyThread extends Thread {
	
	MyTable table;
	
	public MyThread(String threadName, MyTable table) {
		super(threadName);
		this.table = table;
	}
	
	@Override
	public void run() {
		table.table();
	}
	
}
