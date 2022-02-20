package demo.converters;

import java.util.List;
import java.util.stream.Collectors;
import demo.jpa.entity.Customer;
import demo.vo.DemoCustomerVo;


public final class CustomerConverter {

    private CustomerConverter() {
    }

    public static DemoCustomerVo convert(Customer customer) {
        DemoCustomerVo demoVo = new DemoCustomerVo();
        demoVo.setName(customer.getName());
        demoVo.setMobile(customer.getMobile());
        demoVo.setEmail(customer.getEmail());
        demoVo.setCity(customer.getCity());

        /* address */
        demoVo.setAddress(customer.getAddress().getDetail());
        // demoVo.setAddress(customer.getAddressId().toString());

        /* order */
        List orders = customer.getOrders().stream().map(GoodsOrderConverter::convert).collect(Collectors.toList());
        demoVo.setOrders(orders);


        return demoVo;
    }

}
