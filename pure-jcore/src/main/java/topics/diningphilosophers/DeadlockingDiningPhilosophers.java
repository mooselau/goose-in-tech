package topics.diningphilosophers;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DeadlockingDiningPhilosophers {
	public static void main(String[] args) throws IOException {
		int ponder = 5;
		int size = 3;
		
		ExecutorService exec = Executors.newCachedThreadPool();
		Chopstick[] sticks = new Chopstick[size];
		for (int i = 0; i < size; i ++) {
			sticks[i] = new Chopstick();
		}
		for (int i = 0; i < size; i ++) {
			exec.execute(new Philosopher(sticks[i], sticks[(i + 1) % size], i, ponder)); 
		}
		System.out.println("Press 'Enter' to quit");
		System.in.read();
		exec.shutdownNow();
	}
}
