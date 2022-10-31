package com.example07.stoppingthread;

public class MyThread extends Thread {
	
	private boolean stop = false;
	
	public synchronized void doStop() {
		this.stop = true;
	}
	
	public synchronized boolean keepRunning() {
		return this.stop == false;
	}
	
	@Override
	public void run() {
		while(keepRunning()) {
			System.out.println("Running");
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
