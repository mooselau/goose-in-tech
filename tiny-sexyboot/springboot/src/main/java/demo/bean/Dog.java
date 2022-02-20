package demo.bean;

import org.springframework.stereotype.Component;


@Component
public class Dog extends AbstractAnimal {
    @Override
    public void eat() {
        System.out.println("Dogs are eating fast..");
    }
}
