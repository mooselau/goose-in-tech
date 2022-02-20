package rabbitmq;

import org.springframework.boot.test.context.SpringBootTest;
import demo.Application;


@SpringBootTest(classes = Application.class)
public class MessageQueueTest {

    // @Autowired
    // private RabbitMqProducer producer;
    //
    // @Test
    // public void testMessage() {
    //     producer.sendMsg("FAKE NEWS!");
    //
    //     producer.sendUser(new User());
    // }

}
