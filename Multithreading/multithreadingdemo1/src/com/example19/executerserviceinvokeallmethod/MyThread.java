package com.example19.executerserviceinvokeallmethod;

import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {

	private Integer number;

	public MyThread(Integer number) {
		this.number = number;
	}

	@Override
	public String call() throws Exception {
		String msg = "";
		System.out.println(Thread.currentThread().getName() + " thread is running !");
		if (isPrime(number)) {
			msg = number + " is Prime";
		}
		msg = number + " is not Prime";
		
		System.out.println(Thread.currentThread().getName() + " thread is ended !");
		
		return msg;
	}

	public boolean isPrime(int n) {
		for (int i = 2; i < Math.sqrt(n) + 1; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

}
