package corejava;

import java.util.concurrent.atomic.AtomicInteger;

public class JavaThreadTester {

	public static void main(String[] args) {
		JavaThreadTester tester = new JavaThreadTester();
		tester.entrypoint();
	}

	private Object flagChange = new Object();

	private void entrypoint() {

		Thread t1 = new Thread(new CountWorker(1000));
		Thread t2 = new Thread(new CountWorker(1000));
		Thread t3 = new Thread(new CountWorker(1000));
		Thread t4 = new Thread(new CountWorker(1000));
		Thread t5 = new Thread(new CountWorker(1000));

		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();

		// try {
		// t1.join();
		// t2.join();
		// t3.join();
		// t4.join();
		// t5.join();
		// } catch (InterruptedException e) {
		// e.printStackTrace();
		// }

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		p("final target: " + target03);

	}

	private static int target03 = 0;
	private AtomicInteger target01 = new AtomicInteger(0);
	private volatile static int target02 = 0;

	public static void increment() {
		target03 = target03 + 1;
		p(Thread.currentThread().getName() + " pushed number to: " + target03);
	}

	private static void p(String msg) {
		System.out.println(msg);
	}

	class CountWorker implements Runnable {

		private int n = 0;

		public CountWorker(int t) {
			n = t;
		}

		@Override
		public void run() {
			while (n > 0) {
				JavaThreadTester.increment();
				n--;
			}
		}

	}
}
