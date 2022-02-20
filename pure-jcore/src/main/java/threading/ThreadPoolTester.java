package threading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ThreadPoolTester {

    public static void main(String[] args) {
        ThreadPoolTester tt = new ThreadPoolTester();
        tt.entrypoint();
    }

    public void entrypoint() {
        doJob();
    }

    public void doJob() {
        BlockingQueue<RunnableTask> bq = new ArrayBlockingQueue(10);
    }

    private class RunnableTask implements Runnable {

        @Override
        public void run() {
            System.out.println("Running..");
        }
    }

}
