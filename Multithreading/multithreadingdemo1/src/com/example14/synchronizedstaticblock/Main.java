package com.example14.synchronizedstaticblock;

public class Main {

	public static void main(String[] args) {
		
		int number = 10;
		
		MyThread myThread = new MyThread("custom", number);
		myThread.start();
		
		MyTable.table(number);
		// This call will execute after execution MyThread class table() call
		
		MyTable.factors(number); 	
		// Even if we are calling different method still main thread has to wait for the completion
		// of execution of MyThread class table() call because both methods are synchronized.
		// So the rule is - Only one thread can access any of synchronized method present in the class at a time.
		
	}

}
