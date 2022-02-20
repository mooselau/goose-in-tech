package demo.services;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
public class SimpleService {
    public void simpleProcess() {
        LOGGER.info("mock processing..");
    }

    @Async
    public void asyncProcess() {
        LOGGER.info("Here processing asynchronously..");
    }
}
