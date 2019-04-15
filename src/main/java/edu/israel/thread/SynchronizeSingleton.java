package edu.israel.thread;

public class SynchronizeSingleton {
	
	public static void main(String[] args) {
		System.out.println(Singleton.getInstance());
	}
	
}

class Singleton {
	public static Singleton INSTANCE;
	
	private Singleton() {
	}
	
	public static Singleton getInstance() {
		synchronized(INSTANCE) {
			
		}
		
		return INSTANCE;
	}
}