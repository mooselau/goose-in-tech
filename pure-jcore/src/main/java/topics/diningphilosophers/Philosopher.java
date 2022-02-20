package topics.diningphilosophers;

import utils.StringUtilities;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Philosopher implements Runnable {
	private Chopstick left;
	private Chopstick right;
	private int id;
	private int ponderFactor;
	private Random rand = new Random(47);
	
	private StringUtilities tools = StringUtilities.getInstance();
	
	public Philosopher(Chopstick left, Chopstick right, int ident, int ponder) {
		this.left = left;
		this.right = right;
		this.id = ident;
		this.ponderFactor = ponder;
	}
	
	private void pause() throws InterruptedException {
		if (ponderFactor == 0) {
			return ;
		}
		TimeUnit.MILLISECONDS.sleep(rand.nextInt(ponderFactor * 250));
	}
	
	@Override
	public void run() {
		try {
			while(!Thread.interrupted()) {
				tools.println(this + " is thinkging");
				pause();
				// philosopher becomes hungry
				tools.println(this + " grabbing right");
				right.take();
				pause(); // manually make deadlock
				tools.println(this + " grabbing left");
				left.take();
				tools.println(this + " eating");
				pause(); // pause for eating
				tools.println(this + " finished");
				right.drop();
				left.drop();
			}
		} catch(InterruptedException ie) {
			tools.println(this + " " + "exiting via interrupt");
		}
	}
	
	public String toString() {
		return "Philosopher " + id;
	}
	
}
