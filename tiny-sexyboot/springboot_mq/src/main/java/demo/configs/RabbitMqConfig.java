package demo.configs;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMqConfig {

    public static final String MSG_QUEUE = "mq.demo.msg.queue";
    public static final String USER_QUEUE = "mq.demo.user.queue";
    public static final String EXCHANGE = "mq.demo.exchange";
    public static final String MSG_ROUTING_KEY = "mq.demo.routing.key.msg";
    public static final String USER_ROUTING_KEY = "mq.demo.routing.key.user";

    public static final String DEAD_QUEUE = "mq.demo.dead.queue";
    public static final String DEAD_ROUTING_KEY = "mq.demo.routing.key.dead";

    @Bean
    public Queue createQueueMsg() {
        //        return new Queue(MSG_QUEUE, true);
        return QueueBuilder.durable(MSG_QUEUE).deadLetterExchange(EXCHANGE)
                .deadLetterRoutingKey(DEAD_ROUTING_KEY).build();
    }

    @Bean
    public Queue createQueueUser() {
        return new Queue(USER_QUEUE, true);
    }

    @Bean
    public Queue createDLQ() {
        return new Queue(DEAD_QUEUE, true);
    }

    @Bean
    public DirectExchange createExchange() {
        return new DirectExchange(EXCHANGE, true, false);
    }
}
