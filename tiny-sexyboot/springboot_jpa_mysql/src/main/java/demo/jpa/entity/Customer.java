package demo.jpa.entity;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Entity
public class Customer extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    @Column
    private String name;
    @Column
    private String mobile;
    @Column
    private String city;
    @Column
    private String email;

    @OneToOne
    private Address address;
    // @Column
    // private Long addressId;

    @OneToMany(mappedBy = "customer")
    private List<GoodsOrder> orders;

    // (cascade = {CascadeType.ALL})
    //    @OneToMany
    //    @Where(clause = "is_deleted = false")
    //    private List<GoodsOrder> orders;
}
