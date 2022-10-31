package com.example06.sleepingthread;

public class Main {

	public static void main(String[] args) {
		System.out.println("Main thread is running");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Main thread is stopped");
	}

}
