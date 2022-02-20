package demo.bean;

import java.util.List;
import org.springframework.stereotype.Component;


@Component
public class AnimalGuardian {
    public AnimalGuardian(List<AbstractAnimal> animals) {
        System.out.println("Guardian is calling animals to eat..");
        animals.forEach(animal -> animal.eat());
    }
}
