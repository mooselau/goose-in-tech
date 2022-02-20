package demo.rabbitmq;

import static demo.configs.RabbitMqConfig.EXCHANGE;
import static demo.configs.RabbitMqConfig.MSG_ROUTING_KEY;
import static demo.configs.RabbitMqConfig.USER_ROUTING_KEY;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import demo.model.User;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
public class RabbitMqProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMsg(String msg) {
        LOGGER.info("===> Message[{}] Sent!", msg);
        rabbitTemplate.convertAndSend(EXCHANGE, MSG_ROUTING_KEY, msg);
    }

    public void sendUser(User user) {
        LOGGER.info("===> User Message[{}] Sent!", user);
        rabbitTemplate.convertAndSend(EXCHANGE, USER_ROUTING_KEY, user);
    }
}
