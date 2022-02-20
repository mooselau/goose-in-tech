package threading;


public class ThreadStateDemo {

    public static void main(String[] args) {
        ThreadStateDemo demo = new ThreadStateDemo();
        demo.entrypoint();
    }

    private final Object mutex = new Object();
    private boolean flag = false;

    public void entrypoint() {
        Thread workerA = new Thread(this::doSomething02);
        Thread workerB = new Thread(this::doSomething02);

        workerA.start();
        workerB.start();
    }

    private void doSomething02() {
        p(Thread.currentThread().getName() + " in doSomething02()");

        try {
            synchronized (mutex) {
                if (flag) {
                    mutex.notify();
                } else {
                    flag = true;
                    mutex.wait();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        p(Thread.currentThread().getName() + " exits doSomething02()");
    }

    private void doSomething() {
        p(Thread.currentThread().getName() + " in entrypoint()");

        synchronized (mutex) {
            p(Thread.currentThread().getName() + "==> PROCESSING STARTS..");
            p(".. .. ..");
            p(Thread.currentThread().getName() + "==> PROCESSING FINISHED..");
        }

        p(Thread.currentThread().getName() + " exits entrypoint()");
    }

    private void p(String msg) {
        System.out.println(msg);
    }

}
