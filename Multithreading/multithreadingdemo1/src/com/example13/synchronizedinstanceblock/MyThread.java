package com.example13.synchronizedinstanceblock;

import com.example11.synchronizedinstancemethod.MyTable;

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
