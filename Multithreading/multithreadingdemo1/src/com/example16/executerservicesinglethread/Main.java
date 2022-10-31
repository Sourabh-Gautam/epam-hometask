package com.example16.executerservicesinglethread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

	public static void main(String[] args) {
		
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		MyTable myTable = new MyTable(2);
		Runnable runnable = new MyThread(myTable);
		executorService.execute(runnable);
		executorService.execute(runnable);
		executorService.shutdown();

	}

}
