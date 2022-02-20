package javaself;

import model.Person;


public class ObjectTest {
    public static void main(String[] args) {
        ObjectTest demo = new ObjectTest();
        demo.entrypoint();
    }

    private void entrypoint() {
        OtherTester other = new OtherTester();
        Person p = new Person("A", 18);
        System.out.println("===> Tester: Person hashcode: " + p.hashCode() + ", value: " + p.toString());
    }

}
