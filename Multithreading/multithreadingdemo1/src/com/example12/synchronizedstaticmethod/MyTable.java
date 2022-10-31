package com.example12.synchronizedstaticmethod;

public class MyTable {
	
	private MyTable() {
		
	}
	
	public static synchronized void table(int number) {
		
		System.out.println(Thread.currentThread().getName() + " thread is printing this table.");
		
		for(int i=1; i<=10; i++) {
			System.out.println(number*i);
		}
	}
	
	public static synchronized void factors(int number) {
		System.out.println(Thread.currentThread().getName() + " thread is printing these factors.");
		
		for(int i=1; i<=number; i++) {
			if(number%i==0) {
				System.out.println(i);
			}
		}
	}
	
}
