package com.example14.synchronizedstaticblock;

public class MyTable {

	private MyTable() {

	}

	public static void table(int number) {

		synchronized (MyTable.class) {
			System.out.println(Thread.currentThread().getName() + " thread is printing this table.");

			for (int i = 1; i <= 10; i++) {
				System.out.println(number * i);
			}
		}

	}

	public static synchronized void factors(int number) {

		synchronized (MyTable.class) {
			System.out.println(Thread.currentThread().getName() + " thread is printing these factors.");

			for (int i = 1; i <= number; i++) {
				if (number % i == 0) {
					System.out.println(i);
				}
			}
		}
	}

}
