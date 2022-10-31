package com.example13.synchronizedinstanceblock;

public class MyTable {

	private MyTable() {

	}

	public void table(int number) {
		synchronized (this) {
			System.out.println(Thread.currentThread().getName() + " thread is printing this table.");
			for (int i = 1; i <= 10; i++) {
				System.out.println(number * i);
			}
		}
	}

	public void factors(int number) {
		synchronized (this) {
			System.out.println(Thread.currentThread().getName() + " thread is printing these factors.");
			for (int i = 1; i <= number; i++) {
				if (number % i == 0) {
					System.out.println(i);
				}
			}
		}
	}

}
