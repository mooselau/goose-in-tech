package demo.controller;

import javax.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
@RequestMapping("/welcome")
public class Welcome {

    @PostConstruct
    public void init() {
        String str = null;
        LOGGER.info("Test Value: {}", str);
    }

    @GetMapping("")
    public String sayHello() {
        return "Hello, crazy goose!!";
    }

}
