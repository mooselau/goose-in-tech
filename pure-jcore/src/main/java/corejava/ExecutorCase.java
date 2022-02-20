package corejava;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * This is for testing Thread Pool Issues.
 * 
 * @author MooseLiu
 *
 */
public class ExecutorCase {

	private static ExecutorService executor = Executors.newFixedThreadPool(2);
	
	public static void main(String[] args) {
		Future<String> future = executor.submit(new Task("task1"));
		Future<String> future2 = executor.submit(new Task("task2"));
		Future<String> future3 = executor.submit(new Task("task3"));
		//...
		try {
			//String ret = future.get();
			//System.out.println(ret);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	static class Task implements Callable<String> {
		private String name;
		Task(String name) {
			this.name = name;
		}
		@Override
		public String call() throws Exception {
			try {
				System.out.println(Thread.currentThread().getName()+" is doing "+this.name);
				TimeUnit.SECONDS.sleep(2); // sleep 2 seconds
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return "\nThis is submit - callable & future case.";
		}
	}
	
}
