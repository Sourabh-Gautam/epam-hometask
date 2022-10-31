package com.example10.assignment;

// In this assignment we are creating multiple threads. Remember, there is no gaurantee
// which thread is going to execute first.

public class Main {

	public static void main(String[] args) {
		MyThread myThread = new MyThread("Thread 1");
		MyThread myThread2 = new MyThread("Thread 2");
		myThread.start();
		myThread2.start();
//		myThread.run();
//		myThread2.run();
	}

}
