package threading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


public class ThreadPoolDemo {

    public static void main(String[] args) {
        ThreadPoolDemo demo = new ThreadPoolDemo();
        demo.entrypoint();
    }

    private void entrypoint() {

        BlockingQueue<Runnable> blockingQueue = new ArrayBlockingQueue<Runnable>(10);
        ExecutorService es = new ThreadPoolExecutor(3, 6, 3000L, TimeUnit.MILLISECONDS, blockingQueue,
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

    }

}
