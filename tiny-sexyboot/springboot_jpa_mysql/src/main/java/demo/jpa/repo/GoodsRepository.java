package demo.jpa.repo;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import demo.jpa.entity.Goods;


@Repository
public interface GoodsRepository extends JpaRepository<Goods, Long> {

    @Query(value = "SELECT * FROM goods WHERE id = ?1 FOR UPDATE;", nativeQuery = true)
    Optional<Goods> queryGoodsByGoodsIdForUpdate(Long id);

}
