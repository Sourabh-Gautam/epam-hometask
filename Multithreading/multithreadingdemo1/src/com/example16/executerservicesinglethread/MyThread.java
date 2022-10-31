package com.example16.executerservicesinglethread;

public class MyThread implements Runnable {
	
	MyTable table;
	
	public MyThread(MyTable table) {
		this.table = table;
	}
	
	@Override
	public void run() {
		table.table();
	}
	
}
