package demo.rabbitmq;

import static demo.configs.RabbitMqConfig.MSG_QUEUE;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;


@RabbitListener(queues = { MSG_QUEUE })
@Slf4j
@Component
public class MessageConsumer {
    @RabbitHandler
    public void receiveMsg(String msg) {
        LOGGER.info("=>=> Message[{}] Received.", msg);

        // Test Exception Failure
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        throw new RuntimeException("!!FAKE Exception!!");
    }
}
