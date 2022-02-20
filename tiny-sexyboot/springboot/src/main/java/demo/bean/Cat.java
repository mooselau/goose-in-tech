package demo.bean;

import org.springframework.stereotype.Component;


@Component
public class Cat extends AbstractAnimal {
    @Override
    public void eat() {
        System.out.println("Cats are eating slowly..");
    }
}
