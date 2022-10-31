package com.example17.executerservicemultithread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.example16.executerservicesinglethread.MyTable;
import com.example16.executerservicesinglethread.MyThread;

public class Main {

	public static void main(String[] args) {
		
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		MyTable myTable = new MyTable(2);
		Runnable runnable = new MyThread(myTable);
		executorService.execute(runnable);
		executorService.execute(runnable);
		executorService.shutdown();
		
	}

}
