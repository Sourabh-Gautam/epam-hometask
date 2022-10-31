package com.example17.executerservicemultithread;

public class MyTable {
	
	private int number;
	
	public MyTable(int table) {
		this.number = table;
	}
	
	public void table() {
		
		System.out.println(Thread.currentThread().getName() + " thread is printing this table.");
		
		for(int i=1; i<=10; i++) {
			System.out.println(number*i);
		}
	}
	
}
