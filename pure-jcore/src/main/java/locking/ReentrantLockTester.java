package locking;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTester {

	public static void main(String[] args) {
		ReentrantLockTester tester = new ReentrantLockTester();
		tester.entrypoint();
	}
	
	public void entrypoint() {
		boolean useTraditionalLock = false;
		WorkerTask task = new WorkerTask(useTraditionalLock);
		Thread workerA = new Thread(task);
		Thread workerB = new Thread(task);
		workerA.start();
		workerB.start();
		try {
			Thread.currentThread().join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	class WorkerTask implements Runnable {
		
		private boolean useTraditionalLock = false;
		private Object mutex = new Object();
		private ReentrantLock rlock = new ReentrantLock();
		
		public WorkerTask(boolean useTraditionalLock) {
			this.useTraditionalLock = useTraditionalLock;
		}
		
		@Override
		public void run() {
			if (useTraditionalLock) {
				traditionalRun();
			} else {
				complexRun();
			}
		}
		
		private void traditionalRun() {
			System.out.println(Thread.currentThread().getName() + " is entering traditional lock..");
			synchronized(mutex) {
				System.out.println(Thread.currentThread().getName() + " is working now..");
			}
			System.out.println(Thread.currentThread().getName() + " exited traditional lock..");
		}
		
		private void complexRun() {
			System.out.println(Thread.currentThread().getName() + " is entering reentrant lock..");
			rlock.lock();
			try {
				
				System.out.println(Thread.currentThread().getName() + " is working now..");
				
			} finally {
				rlock.unlock();
			}
			System.out.println(Thread.currentThread().getName() + " exited reentrant lock..");
		}
		
	}
	
}
