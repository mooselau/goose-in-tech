package demo.utils;

import demo.jpa.entity.Customer;
import demo.jpa.entity.GoodsOrder;


public final class OrderUtil {

    private OrderUtil() {}

    public static GoodsOrder buildOrder(String memo, Customer customer) {
        GoodsOrder order = new GoodsOrder();
        order.setMemo(memo);
        order.setCustomer(customer);
        return order;
    }
}
