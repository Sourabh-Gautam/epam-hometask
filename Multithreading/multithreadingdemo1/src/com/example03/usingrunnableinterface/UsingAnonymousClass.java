package com.example03.usingrunnableinterface;

public class UsingAnonymousClass {

	public static void main(String[] args) {
		Runnable runnable = new Runnable() {

			@Override
			public void run() {
				System.out.println("MyThread is running !");
			}
			
		};
		
		Thread thread = new Thread(runnable);
		thread.start();
		
	}

}
