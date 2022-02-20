package demo.models;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class SampleModel {

    @Value("${model.one-name:haha}")
    private String modelname;

    public void printModelName() {
        System.out.println("===> printModelName: " + modelname);
    }

}
