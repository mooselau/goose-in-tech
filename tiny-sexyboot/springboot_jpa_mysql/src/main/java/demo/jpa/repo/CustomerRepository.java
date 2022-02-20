package demo.jpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import demo.jpa.entity.Customer;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
