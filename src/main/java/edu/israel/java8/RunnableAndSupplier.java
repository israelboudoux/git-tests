package edu.israel.java8;

public class RunnableAndSupplier {

	public static void main(String[] args) throws InterruptedException {
		execute(() -> System.out.println("blablabla"));
		Thread.sleep(2000L);
		execute(() -> 1);
	}
	
	public static void execute(Runnable r) {
		System.out.println("Running runnable...");
		r.run();
	}
	
	public static <T> void execute(java.util.function.Supplier<T> supplier) {
		System.out.println("Running supplier");
		supplier.get();
	}
	
}
