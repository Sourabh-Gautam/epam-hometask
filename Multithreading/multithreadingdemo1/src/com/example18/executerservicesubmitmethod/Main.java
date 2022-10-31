package com.example18.executerservicesubmitmethod;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		
		Callable<String> callable = new MyThread(6);
		Future<String> future = executorService.submit(callable); 
			// The main thread will wait here to return Future by this statement because Future is going to be use further.
		System.out.println(future.get()); 
		
		System.out.println("Main thread end");
		
		executorService.shutdown();
	}

}
