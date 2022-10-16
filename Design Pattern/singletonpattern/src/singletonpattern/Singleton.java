package singletonpattern;

public class Singleton {
	
	
	
	private Singleton() {
		
	}
	
	public Singleton getInstance() {
		return new Singleton();
	}
	
}
