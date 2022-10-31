package com.example03.usingrunnableinterface;

public class UsingLambdaExpression {

	public static void main(String[] args) {
		Runnable runnable = () -> {
				System.out.println("MyThread is running !");			
		};
		
		Thread thread = new Thread(runnable);
		thread.start();
		
	}

}
