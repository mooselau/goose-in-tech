package demo.jpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import demo.jpa.entity.Address;


@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
