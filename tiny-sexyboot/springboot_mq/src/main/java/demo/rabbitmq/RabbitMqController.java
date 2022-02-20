package demo.rabbitmq;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import demo.model.MsgInput;
import demo.model.User;

@RestController
@RequestMapping("/demo/rabbitmq")
public class RabbitMqController {

    @Autowired
    private RabbitMqProducer rabbitMqProducer;

    @PostMapping("/msg")
    public void msg(@RequestBody MsgInput input) {
        rabbitMqProducer.sendMsg(input.getMessage());
    }

    @PostMapping("/user")
    public void user(Long id, String userName, String note) {
        rabbitMqProducer.sendUser(new User());
    }

    private Map<String, Object> resultMap(String key, Object object) {
        Map<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put(key, object);
        return result;
    }

}
