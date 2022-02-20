package threading;

import org.apache.commons.lang3.RandomStringUtils;


/**
 * Use Synchronized to demo Producer-Consumer.
 */
public class ThreadingSyncProducer {

    private ThreadingSyncQueue<String> queue;

    public ThreadingSyncProducer() {
        queue = new ThreadingSyncQueue(2);
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
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private String generateTask() {
        return RandomStringUtils.randomAlphanumeric(3);
    }

    public ThreadingSyncQueue getQueue() {
        return queue;
    }

    private void p(String msg) {
        System.out.println(msg);
    }

    /* Start Point */
    public static void main(String[] args) {
        ThreadingSyncProducer producer = new ThreadingSyncProducer();
        producer.entrypoint();

        ThreadingSyncConsumer consumer = new ThreadingSyncConsumer(producer);
        consumer.entrypoint();
    }

    private void entrypoint() {
        Thread workerA = new Thread(this::start);
        Thread workerB = new Thread(this::start);

        workerA.start();
        workerB.start();
    }

}
