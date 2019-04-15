package edu.israel.thread;

public class ThreadTest01 {
	
	public static void main(String[] args) {
		
		new Thread(() -> {
			for(int i = 1; i <= 10; i++) {
				try {
					System.out.println(String.format("I'm running until 10: %d", i));
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			throw new RuntimeException("WTF");
		}).start();
		
		System.out.println("Bye, bye!");
	}
	
}
