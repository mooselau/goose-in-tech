package locking;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockNConditionTester {

	public static void main(String[] asrgs) {
		ReentrantLockNConditionTester tester = new ReentrantLockNConditionTester();
		tester.entrypoint();
	}

	public void entrypoint() {
		RunnableTask task = new RunnableTask();
		Thread a = new Thread(task);
		Thread b = new Thread(task);

		a.start();
		b.start();

		try {
			Thread.currentThread().sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		task.doChange();
		System.out.println("Main thread changed the condition!");
	}

	private class RunnableTask implements Runnable {
		private ReentrantLock lock = new ReentrantLock();
		private Condition cond = lock.newCondition();
		private volatile boolean flag = true;

		@Override
		public void run() {
			waitChange();
			finish();
		}

		public void doChange() {
			lock.lock();
			try {
				flag = false;
				cond.signalAll();
			} finally {
				lock.unlock();
			}
		}

		private void waitChange() {
			lock.lock();
			try {
				while (flag) {
					cond.await();
					System.out.println(Thread.currentThread() + " awaken!!");
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				lock.unlock();
			}
		}

		private void finish() {
			System.out.println(Thread.currentThread().getName() + " finishes the job!");
		}
	}

}
