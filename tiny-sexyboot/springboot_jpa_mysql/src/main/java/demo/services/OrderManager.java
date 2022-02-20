package demo.services;

import static demo.converters.GoodsOrderConverter.convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import demo.jpa.entity.Customer;
import demo.jpa.entity.GoodsOrder;
import demo.jpa.repo.CustomerRepository;
import demo.jpa.repo.GoodsRepository;
import demo.jpa.repo.OrderRepository;
import demo.utils.OrderUtil;
import demo.vo.OrderVo;


@Service
public class OrderManager {
    @Autowired
    private GoodsRepository goodsRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private OrderRepository orderRepository;

    @Transactional
    public Long createOrder(OrderVo orderVo) {

        Long customerId = orderVo.getCustomerId();
        Customer customer = customerRepository.findById(customerId).orElseThrow(RuntimeException::new);

        GoodsOrder order = OrderUtil.buildOrder(orderVo.getMemo(), customer);
        orderRepository.save(order);

        // manually link customer and new order
        // Long customerId = orderVo.getCustomerId();
        // Customer customer = customerRepository.findById(customerId).orElseThrow(RuntimeException::new);
        customer.getOrders().add(order);
        customerRepository.save(customer);

        return order.getId();
    }

    @Transactional(readOnly = true)
    public OrderVo getOrder() {
        GoodsOrder order = orderRepository.findById(1l).orElseThrow(RuntimeException::new);
        return convert(order);
    }

}
