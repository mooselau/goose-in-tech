package demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import demo.services.SimpleService;


@RestController
@RequestMapping("/demo")
public class SimpleController {
    @Autowired
    private SimpleService simpleService;

    @GetMapping("")
    public void demoLogging() {
        simpleService.simpleProcess();
    }

    @GetMapping("/async")
    public void demoAsyncLogging() {
        simpleService.asyncProcess();
    }
}
