package demo.configs;

import javax.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Configuration
public class AppConfig {

    public AppConfig() {
        LOGGER.info("=> constructor");
    }

    @PostConstruct
    public void chushi() {
        LOGGER.info("=> chushihua");
    }
}
