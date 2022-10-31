package com.example15.volatilekeyword;

// Volatile keyword is used to stop caching coherence.

public class Main {

	private static int counter = 0; 

	public static void main(String[] args) {

		Thread t1 = new Thread(() -> {
			int localCounter = counter;

			while (localCounter < 10) {
				if (localCounter != counter) {
					System.out.println("[T1] local counter is changed - "+localCounter);
					localCounter = counter;
				}
			}
		});

		Thread t2 = new Thread(() -> {
			int localCounter = counter;

			while (localCounter < 10) {
				System.out.println("[T2] Incremented counter to " + (localCounter + 1));
				counter = ++localCounter;

				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		t1.start();
		t2.start();

	}

}
