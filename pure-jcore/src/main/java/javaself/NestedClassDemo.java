package javaself;

public class NestedClassDemo {
    private int[] data;

    NestedClassDemo(int size) {
        data = new int[size];
    }

    class InnerClass {
        private int[] data;

        InnerClass(int size) {
            data = new int[size];
        }
    }
}
