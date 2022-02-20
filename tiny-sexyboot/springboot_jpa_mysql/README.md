# Mysql_Lab

Used to test DB related issues, using Mysql as backend DB.

## Topics

1. Entity Relations

*. Status Field Converter
*. Entity Mapping: when use mapping annotations?
*. What is Casade? When to use Casade?
*. How to generate external ID for given entity?

## 1 Entity Relation

### 1.1 One-to-One Mapping
```java
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column
    private Long addressId;
}

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column
    private Long customerId;
}
```
- 这是最简单的处理办法，通过将双方的 ID 放在对方 Entity 的字段中，在需要的时候通过 JPA Repository 来查询； 

```java
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    
    @Column
    private Long addressId;
}

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
}
```
- 上面这种是比较实际的处理方式，实际情况中，可能并不需要在双方的 Entity 中添加ID，比如上方用例；
- 由于 并不经常需要通过 Address 来查询 Customer，所以只留下 Customer 中的 addressId，这样当需要查询某个客户的地址的时候，在 Address Entity JPA Repository 中通过 addressID 就可以查询到，另外当需要通过 Address 来查询 Customer 的时候，可以通过 Customer JPA Repository 来查询 addressID 达到目的。 
- 这种写法OK，但是要注意的是：需要先保存 Address Entity 并且获得 Entity.ID 才能继续持久化 Customer；

- 另外这种写法，如果需要通过 customer 获取 address，需要额外 从 AddressRepo 读取一次才可以，比如下方的操作：
```java
public class DemoCustomerManager {
     @Transactional
     public Long createCustomer(Input input) {
         // first to save address
         Address address = buildAddress(input);
         addressRepository.save(address);
 
         // save new customer
         Customer customer = buildCompleteCustomer(input, address.getId());
         customerRepository.save(customer);
         return customer.getId();
     }
    
     public Address getAddress(Customer customer) {
         // additional check to get address from customer
         Long addressId = customer.getAddressId();
         return addressRepo.findById(addressId);
     }
}
```

- 另一种写法就是使用 Entity 作为属性，如下：
```java
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @OneToOne
    private Address address;
}

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
}
```
- 注意这里必须要明确 @OneToOne, 因为JPA需要这个 annotation 来明确这是一个外键，否则会报错无法确定这个 type；
- 在 one-to-one 中，相对于使用 ID 作为属性，个人还是推荐使用 Entity 作为属性，更加方便也直接；

### 1.2 One-to-Many & Many-to-One Mapping

#### 1.2.0 Pre Qs

- Q: 使用 ID 作为属性?
> 在一对多关系中，如果都用 对方ID 做属性，会很麻烦，因为 List<Long> 会不被识别进而报错，另外，每次存储 Entity，都会需要先存依赖方，这样才能拿到 Entity ID，不如考虑直接使用 注解；

- Q: 使用Entity Class的情况?
> 如果仅仅只使用类作为属性的话，是会报错的，比如 Customer::List<GoodsOrder> orders, GoodsOrder::Customer customer, 这种情况下，这两者都会有 "Could not determine type" 的无法识别类型的错误（根本原因应该是无法映射到/找到相对应的 Column），正确的做法应该是配合注解一起使用；

以下都会以注解搭配Entity的形式来进行说明。

#### 1.2.1 Unidirectional Mapping / Relationship

单项映射或者关系，指的是单独使用 @OneToMany 或者 @ManyToOne 的场景，这种情况下，从 A 到 B 或者 从 B 到 A 中的某一种是可行的。

假如 Customer 是不需要知道 Order 的信息，但是需要从 Order 信息直接查询到 Customer 信息，Entity 定义代码可能如下：
```java
@Entity
public class GoodsOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    
    @ManyToOne
    private Customer customer;
}
```

- 单向的关系这里并不需要在 Customer 定义任何 Order 信息;

#### 1.2.2 Two Unidirectional Mapping / Relationship

这种关系并不是真正意义上的双向关系，它需要双向同时使用 @OneToMany 和 @ManyToOne 的场景，这种情况下，从 A 到 B 和 从 B 到 A 都是可行的，但是会有额外的操作。

比如，如果要持久化对象，需要操作两个repository，先存（一个对象）后取（这个对象ID）再存（另一个对象），但是如果是真正的双向关系，只需要持久化其中一个对象，另一个对象就会自动持久化了。

此时的 Entity 的定义如下：
```java
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @OneToMany
    private List<GoodsOrder> orders;
}

@Entity
public class GoodsOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @ManyToOne
    private Customer customer;
}
```
- 在上方这种定义情况下，DB会自动创建一个中间表：customer_orders (当然可以自定义中间表并进行设置)，中间表中关联了 Customer 和 Order 的主键；

- 在这种定义方式的情况下，要这样进行持久化：
```java
@Service
public class OrderManager {

        @Transactional
        public Long createOrder(OrderVo orderVo) {
            // get customer and prepare new order entity
            Long customerId = orderVo.getCustomerId();
            Customer customer = customerRepository.findById(customerId).orElseThrow(RuntimeException::new);
            GoodsOrder order = OrderUtil.buildOrder(orderVo.getMemo(), customer);
            // firstly, save order entity
            orderRepository.save(order);

            // modify customer's order list
            customer.getOrders().add(order);
            // then, save and flush customer
            customerRepository.save(customer);
            return order.getId();
        }
}
```
- 必须要前后对相关对象进行存储吗？
> 是的，如果单独保存 Order 到 Customer.OrderList 依然会有报错 - 有reference不是 transient 同时也没有持久化 而导致直接持久化 Customer 失败；
> 这种情况下，只能先 save Order，再 save Customer;

#### 1.2.2 Bidirectional Mapping / Relationship

对于双向映射或者关系，除了同时使用 @OneToMany 和 @ManyToOne 的场景，还需要搭配 @OneToMany 的配置 (mappedBy = "customer") ，这种情况下，从 A 到 B 和 从 B 到 A 都是可行的，而且不需要额外的多余的操作。

此时的 Entity 的定义如下：
```java
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @OneToMany(mappedBy = "customer")
    private List<GoodsOrder> orders;
}

@Entity
public class GoodsOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @ManyToOne
    private Customer customer;
}
```
- 此时，DB是不会创建中间表的，Customer 和 Order 表直接关联了；

- 这种情况下，只需要这样进行持久化：
```java
@Service
public class OrderManager {
        @Transactional
        public Long createOrder(OrderVo orderVo) {
            // prepare customer and save into new Order Entity
            Long customerId = orderVo.getCustomerId();
            Customer customer = customerRepository.findById(customerId).orElseThrow(RuntimeException::new);
            GoodsOrder order = OrderUtil.buildOrder(orderVo.getMemo(), customer);
            orderRepository.save(order);
            return order.getId();
        }
}
```

- 在存储 Order 的时候，只需要提前获取 Customer Entity，连同 Order 一起持久化到 repository 就可以成功关联这两个 Entity 了;
- 在之后需要读取 Customer 的时候，会自动 Load 关联的 Order 放入到 Order List 读取出来，在需要读取 Order 的时候，会通过 Customer 外键自动 Load 出 Customer Entity；



- 为什么base Entity的属性都不在？

## 2 Annotations
常见的 Entity Annotations 解释和用法

### 2.1 @Column
默认情况下不需要使用，但是当我们需要设定某个字段某个属性的时候，可以使用，比如：name, unique, nullable, length 等等。

- fetch, lazyload, casade ??

- 如果设置transient属性，不会同步到DB？
- @Transient

### 3 Bullet Notes

- 在生产环境中，下方的配置是不允许使用的：

```yaml
spring:
  jpa:
    hibernate:
      ddl-auto: xxxx
```

因为ddl-auto是为了在项目启动和关闭的时候进行更新数据库数据表Schema，同时可能会清空数据，所以非常不建议在生产环境使用这个配置。

- 在生产环境中，会有特定的SQL Scripts来更新数据库数据表，所以生产环境只需要准备好SQL和Entity代码就足够了；
- Spring JPA可以使得驼峰命名自动映射到数据库的蛇形命名，比如：GoodsOrder 会自动映射为 goods_order，所以不用声明自定义表名或者字段名。