package com.example05.assignment;

// In this assignment we are creating multiple threads. Remember, there is no gaurantee
// which thread is going to execute first.

public class Main {

	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName());
		for(int i=1; i<=10; i++) {
			new Thread("thread "+i) {
				@Override
				public void run() {
					System.out.println(getName());
				}
			}.start();
		}
	}

}
