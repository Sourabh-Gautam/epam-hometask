package com.example20.executerserviceinvokeanymethod;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		ExecutorService executorService = Executors.newFixedThreadPool(5);

		List<Callable<String>> callables = List.of(new MyThread(3), new MyThread(8), new MyThread(13), new MyThread(43),
				new MyThread(98));
		String result = executorService.invokeAny(callables);

		System.out.println(result);

		System.out.println("Main thread end");

		executorService.shutdown();
	}

}
