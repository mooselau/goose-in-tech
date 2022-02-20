package demo.jpa.converter;

import javax.persistence.AttributeConverter;
import demo.jpa.model.OrderStatus;


public class OrderStatusConverter implements AttributeConverter<OrderStatus, String> {
    @Override
    public String convertToDatabaseColumn(final OrderStatus orderStatus) {
        return null;
    }

    @Override
    public OrderStatus convertToEntityAttribute(final String s) {
        return null;
    }
}
