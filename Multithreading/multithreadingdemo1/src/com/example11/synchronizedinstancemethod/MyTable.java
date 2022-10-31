package com.example11.synchronizedinstancemethod;

public class MyTable {
	
	private int number;
	
	public MyTable(int table) {
		this.number = table;
	}
	
	public synchronized void table() {
		
		System.out.println(Thread.currentThread().getName() + " thread is printing this table.");
		
		for(int i=1; i<=10; i++) {
			System.out.println(number*i);
		}
	}
	
	public synchronized void factors() {
		System.out.println(Thread.currentThread().getName() + " thread is printing these factors.");
		
		for(int i=1; i<=number; i++) {
			if(number%i==0) {
				System.out.println(i);
			}
		}
	}
	
}
