package demo.entrypoint;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import demo.controller.SimpleProcessor;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SimpleProcessorITCase {

    @Autowired
    private SimpleProcessor processor;

    @LocalServerPort
    private int port;

    @Test
    public void testDoSth() {
        p("Beginning testing..");
        processor.doSth();
        p("Finishing testing..");
    }

    public void p(String msg) {
        System.out.println(msg);
    }

}
