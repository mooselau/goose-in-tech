package javaself;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class StringTester {
    public static void main(String[] args) {
        StringTester tester = new StringTester();
        tester.entrypoint();
    }
    private void entrypoint() {
        String str = "100010";
        Long l = 10000L;
        System.out.println(String.format("String(%d) is invalid, for value(%d)", l, l));
        LOGGER.info("String({}) is invalid, for value(v{})", l, l);
    }
}
