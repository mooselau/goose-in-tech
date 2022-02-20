package demo.rabbitmq;

import static demo.configs.RabbitMqConfig.USER_QUEUE;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import demo.model.User;
import lombok.extern.slf4j.Slf4j;


@RabbitListener(queues = { USER_QUEUE })
@Slf4j
@Service
public class UserMessageConsumer {

    @RabbitHandler
    public void receiveUser(User user) {
        LOGGER.info("=>=> User[{}] Message Received.", user);
    }
}
