package javaself;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


public class StreamDemo {

    public static void main(String[] args) {
        StreamDemo tester = new StreamDemo();
        tester.entrypoint();
    }

    public void entrypoint() {
        testStreamOnFilter();
    }

    private void testStreamOnFilter() {
        List<Person> list = Arrays.asList(new Person("Lily", 18), new Person("Tom", 20),
                new Person("Jerry", 22));
        list.stream().filter(person -> person.getName().equals("Tom")).findFirst()
                .ifPresent(person -> person.setAge(28));
        for (Person p : list) {
            System.out.println("Person - Name: " + p.getName() + ", Age: " + p.getAge());
        }
    }

    private void streamOnRegEx() {
        List<String> list = Arrays.asList("LOW", "LOW", "LOW");
        Set<String> set = new HashSet<>(list);
        //        boolean isHigh = list.stream().anyMatch(element -> element.contains("HIGH"));
        //        boolean isLow = list.stream().anyMatch(element -> element.contains("LOW"));
        boolean isHigh = set.contains("HIGH");
        boolean isLow = set.contains("LOW");
        System.out.println("IsHigh: " + isHigh + "; isLow: " + isLow);
        System.out.println(isHigh ? "HIGH" : isLow ? "LOW" : "NONE");
    }

    /**
     * Stream with Sorted
     */
    private void streamOnComparator() {
        List<Integer> list = Arrays.asList(2, 4, 1, 3, 7, 5, 9, 6, 8);

        Integer minimum = list.stream()
                .min((i1, i2) -> i2.compareTo(i1)).orElse(null);

        System.out.println(minimum);
    }

    /**
     * Stream function on objects
     */
    private void streamOnObject() {
        List<Person> persons = Arrays.asList(new Person("Amy", 17), new Person("Tom", 22),
                new Person("Lucy", 35));
        Person findFirst = persons.stream().findFirst().orElseThrow(RuntimeException::new);
        System.out.println("findFirst: " + findFirst.getName());

        List<Person> result = persons.stream().filter(person -> person.getAge() < 99).collect(Collectors.toList());
        System.out.println("result: " + result.size());

        for (Person p : result) {
            System.out.print("Name: " + p.getName() + ", age: " + p.getAge() + "\t");
        }
    }

    @Getter
    @Setter
    @AllArgsConstructor
    private class Person {
        private String name;
        private int age;
    }
}
