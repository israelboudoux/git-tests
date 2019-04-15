package edu.israel.thread;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class FixedThreadPoolExecutor {

	public static void main(String[] args) throws InterruptedException {
//		ThreadPoolExecutor executorService = (ThreadPoolExecutor) Executors.newCachedThreadPool();
		ThreadPoolExecutor executorService = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
		
		for(int i = 1; i <= 20; i++) {
			final int j = i;
			executorService.execute(() -> {
				for(int k = 1; k <= 5; k++) {
					System.out.println("My name is :" + j);
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
				System.out.println("Bye:" + j);
			});
		}
		
		System.out.println("All threads are in the executor...");
		
		Thread.sleep(10000);
		
		System.out.println("Adding new thread...");
		executorService.execute(() -> System.out.println("Hey Jow Thread!"));
		
		System.out.println("Shutting down...");
		for(int i = 10; i > 0; i--) {
			System.out.println("Shutting down in T-" + i);
			Thread.sleep(1000);
		}

//		System.out.println("Shuting down...bye, bye...");
//		executorService.shutdown();
		
		System.out.println("Shuting down...bye, bye threads in execution...");
		java.util.List<Runnable> runnables = executorService.shutdownNow();
		System.out.println("Non executed threads: " + runnables.size());
		
		while(! executorService.isTerminated()) {
			System.out.println("Yet in execution... Running: " + executorService.getActiveCount() + " / Queue: " + executorService.getQueue().size());
			Thread.sleep(2000);
		}
		
		System.out.println("All threads down!!!!");
	}
}
