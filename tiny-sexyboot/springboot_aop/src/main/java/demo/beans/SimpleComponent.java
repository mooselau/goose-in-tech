package demo.beans;

import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import demo.aop.LogExecution;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Component
public class SimpleComponent {

    @PostConstruct
    public void init() {
    }

    @LogExecution
    public void doAdding() {
        LOGGER.info("Adding: " + (1000 + 9999));
    }

}
