package com.example11.synchronizedinstancemethod;

// Synchronized keyword is used to get rid of the problem called RACE CONDITION.

public class Main {

	public static void main(String[] args) {
		
		MyTable table = new MyTable(10);
		
		MyThread myThread = new MyThread("custom", table);
		myThread.start();
		
		table.table();
		// This call will execute after execution MyThread class table() call
		
		table.factors(); 	
		// Even if we are calling different method still main thread has to wait for the completion
		// of execution of MyThread class table() call because both methods are synchronized.
		// So the rule is - Only one thread can access any of synchronized method present in the class at a time.
		
	}

}
