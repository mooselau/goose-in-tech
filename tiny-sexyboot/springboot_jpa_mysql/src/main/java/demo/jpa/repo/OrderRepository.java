package demo.jpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import demo.jpa.entity.GoodsOrder;


@Repository
public interface OrderRepository extends JpaRepository<GoodsOrder, Long> {
}
