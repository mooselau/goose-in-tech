package threading;

import java.util.concurrent.ArrayBlockingQueue;
import org.apache.commons.lang3.RandomStringUtils;


/**
 * Use Blocking Queue to demo Producer-Consumer.
 */
public class ThreadingBLQProducer {

    private ArrayBlockingQueue<String> queue;

    public ThreadingBLQProducer() {
        queue = new ArrayBlockingQueue<>(2);
    }

    public void start() {
        while (true) {
            try {
                // adding job
                String newTask = generateTask();
                p(String.format("%s - new job [%s] created, waiting to add to queue", Thread.currentThread().getName(),
                        newTask));
                queue.put(newTask);
                p(String.format("%s - new job [%s] added to queue", Thread.currentThread().getName(), newTask));

                // sleep 2s
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private String generateTask() {
        return RandomStringUtils.randomAlphanumeric(3);
    }

    // provide queue to consumer
    public ArrayBlockingQueue<String> getQueue() {
        return queue;
    }

    private void p(String msg) {
        System.out.println(msg);
    }

    /* Start Point */
    public static void main(String[] args) {
        ThreadingBLQProducer producer = new ThreadingBLQProducer();
        producer.entrypoint();

        ThreadingBLQConsumer consumer = new ThreadingBLQConsumer(producer);
        consumer.entrypoint();
    }

    private void entrypoint() {
        Thread workerA = new Thread(this::start);
        Thread workerB = new Thread(this::start);

        workerA.start();
        workerB.start();
    }
}
