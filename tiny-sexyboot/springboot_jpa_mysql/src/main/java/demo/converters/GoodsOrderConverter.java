package demo.converters;

import demo.jpa.entity.GoodsOrder;
import demo.vo.OrderVo;


public final class GoodsOrderConverter {
    private GoodsOrderConverter() {}

    public static OrderVo convert(GoodsOrder order) {
        OrderVo orderVo = new OrderVo();
        orderVo.setMemo(order.getMemo());
        orderVo.setCustomerId(order.getCustomer().getId());
        return orderVo;
    }

}
