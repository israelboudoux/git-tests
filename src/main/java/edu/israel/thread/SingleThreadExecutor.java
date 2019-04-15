package edu.israel.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadExecutor {
	
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		
		for(int i = 1; i < 30; i++) {
			final int j = i;
			executorService.execute(() -> {
				for(int k = 1; k < 5; k++) {
					System.out.println("My name is :" + j);
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
				System.out.println("Bye:" + j);
			});
		}
	}
	
}
