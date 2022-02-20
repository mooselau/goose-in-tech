package javaself;

import java.io.IOException;


public class ExceptionsDemo {
    public static void main(String[] args) {
        ExceptionsDemo demo = new ExceptionsDemo();
        demo.entrypoint();
    }

    private void entrypoint() {
        try {
            this.throwsSneakyIOException();
        } catch (Exception ex) {
            System.out.println(ex.getMessage().toString());
        }
    }

    public static <E extends Throwable> void sneakyThrow(Throwable e) throws E {
        throw (E) e;
    }

    private static void throwsSneakyIOException() {
        sneakyThrow(new IOException("sneaky"));
    }
}
