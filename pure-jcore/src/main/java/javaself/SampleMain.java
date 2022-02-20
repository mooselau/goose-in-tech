package javaself;

import java.io.IOException;
import utils.MemoryChecker;


public class SampleMain {

    private MemoryChecker memoryChecker = new MemoryChecker();

    public static void main(String[] args) throws Exception {
        SampleMain main = new SampleMain();
        main.entrypoint();
    }

    public void entrypoint() throws IOException {
        demoNestedClass();
    }

    private NestedClassDemo oneParent;

    private void demoNestedClass() throws IOException {
        int count = 1;
        oneParent = new NestedClassDemo(100000);

        while (true) {
            System.out.println("Count: " + count);
            memoryChecker.checkTotalMemory();

            instanceCreation();

            memoryChecker.checkFreeMemory();
            memoryChecker.checkMemoryUsage();
            count++;

            if (count % 10 == 0) {
                System.in.read();
            }
        }
    }

    private void instanceCreation() {
        final int size = 100000;
        NestedClassDemo.InnerClass inner = oneParent.new InnerClass(size);
    }
}
