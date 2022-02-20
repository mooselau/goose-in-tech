package demo.beans;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class SimpleService {
    @Autowired
    private SimpleComponent simpleComponent;

    @PostConstruct
    public void init() {
        simpleComponent.doAdding();
    }

}
