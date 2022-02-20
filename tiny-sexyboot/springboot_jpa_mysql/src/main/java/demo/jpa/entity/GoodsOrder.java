package demo.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import demo.jpa.converter.OrderStatusConverter;
import demo.jpa.model.OrderStatus;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Entity
public class GoodsOrder extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    @Column
    private String externalId;

    @Convert(converter = OrderStatusConverter.class)
    private OrderStatus orderStatus = OrderStatus.INIT;

    private String memo;

    // private Long customerId;
    @ManyToOne
    // @Where(clause = "is_deleted = false")
    private Customer customer;

    // @ManyToMany(mappedBy = "order")
    // private List<Delivery> deliveryList;

    //    @NotNull
    //    private Integer quantity;
}
