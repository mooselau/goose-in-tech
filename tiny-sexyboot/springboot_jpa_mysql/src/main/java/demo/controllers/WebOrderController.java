package demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import demo.services.OrderManager;
import demo.vo.OrderVo;


@RequestMapping("/demo")
@RestController
public class WebOrderController {

    @Autowired
    private OrderManager orderManager;

    @PostMapping("/order")
    public ResponseEntity<String> createOrder(@RequestBody OrderVo orderVo) {
        Long orderId = orderManager.createOrder(orderVo);
        return ResponseEntity.ok(String.valueOf(orderId));
    }

    @GetMapping("/order")
    public ResponseEntity<OrderVo> getOrder() {
        return ResponseEntity.ok(orderManager.getOrder());
    }

}
