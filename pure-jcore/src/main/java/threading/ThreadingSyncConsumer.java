package threading;

/**
 * Use Synchronized to demo Producer-Consumer.
 */
public class ThreadingSyncConsumer {

    private ThreadingSyncQueue<String> queue;

    public ThreadingSyncConsumer(ThreadingSyncProducer producer) {
        queue = producer.getQueue();
    }

    public void entrypoint() {
        generateWorkers();
    }

    private void start() {
        while (true) {
            try {
                // polling job
                p(String.format("%s - is waiting new job", Thread.currentThread().getName()));
                String newTask = queue.take();
                p(String.format("%s - new job [%s] taken & processing", Thread.currentThread().getName(), newTask));

                // sleep 2s
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void generateWorkers() {
        Thread workerC = new Thread(this::start);
        Thread workerD = new Thread(this::start);

        workerC.start();
        workerD.start();
    }

    private void p(String msg) {
        System.out.println(msg);
    }
}
