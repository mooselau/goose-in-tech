package demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import demo.services.DemoCustomerManager;
import demo.vo.DemoCustomerVo;


@RequestMapping("/demo")
@RestController
public class WebDemoController {

    @Autowired
    private DemoCustomerManager demoManager;

    @GetMapping("/customer")
    public ResponseEntity<DemoCustomerVo> demoAddCustomer() {
        DemoCustomerVo demoVo = demoManager.getCustomer();
        return ResponseEntity.ok(demoVo);
    }

    @PostMapping("/customer")
    public ResponseEntity<Long> demoAddCustomer(@RequestBody DemoCustomerVo customerVo) {
        Long id = demoManager.createCustomer(customerVo);
        return ResponseEntity.ok(id);
    }

}
