package com.example03.usingrunnableinterface;

public class Main {

	public static void main(String[] args) {
		MyThread myThread = new MyThread();
		Thread thread = new Thread(myThread);
		thread.start();
	}

}
