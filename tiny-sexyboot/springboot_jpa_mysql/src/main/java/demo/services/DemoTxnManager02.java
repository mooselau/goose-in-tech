package demo.services;

import static demo.utils.CustomerUtil.buildCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import demo.jpa.entity.Customer;
import demo.jpa.repo.CustomerRepository;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
public class DemoTxnManager02 {

    @Autowired
    private CustomerRepository customerRepository;

    @Transactional(propagation = Propagation.NESTED)
    public Long demoNewFunction(String name) {
        Customer newCustomer = buildCustomer(name);
        Customer saved02 = customerRepository.save(newCustomer);
        flag(name);
        return saved02.getId();
    }

    private void flag(String name) {
        if (name.contains("err")) {
            throw new RuntimeException("NEST Exception is throwing..");
        }
    }

}
