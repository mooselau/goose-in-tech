package javaself;

public class RandomDemo {
    public static void main(String[] args) {
        RandomDemo demo = new RandomDemo();
        demo.entrypoint();
    }

    private void entrypoint() {
        System.out.println((int) (Math.random() * 1000000));
    }
}
