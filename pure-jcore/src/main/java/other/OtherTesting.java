package other;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class OtherTesting {
    public static void main(String[] args) {
        OtherTesting tester = new OtherTesting();
        tester.entrypoint();
    }

    public void entrypoint() {

    }

    @Getter
    @Setter
    @AllArgsConstructor
    public class Person {
        private String name;
        private String mobile;
    }

}
