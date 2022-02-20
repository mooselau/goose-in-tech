package demo.services;

import static demo.converters.CustomerConverter.convert;
import static demo.utils.CustomerUtil.buildCompleteCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import demo.jpa.entity.Customer;
import demo.jpa.repo.AddressRepository;
import demo.jpa.repo.CustomerRepository;
import demo.vo.DemoCustomerVo;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
public class DemoCustomerManager {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private AddressRepository addressRepository;

    @Transactional
    public Long createCustomer(DemoCustomerVo customerVo) {
        // first to save address
        // Address address = buildAddress(customerVo.getAddress());
        // addressRepository.save(address);

        // save new customer
        Customer customer = buildCompleteCustomer(customerVo.getName(), customerVo.getMobile(), customerVo.getCity(),
                customerVo.getEmail(), customerVo.getAddress());

        addressRepository.save(customer.getAddress());
        customerRepository.save(customer);
        return customer.getId();
    }

    public DemoCustomerVo getCustomer() {
        Customer customer = customerRepository.findById(1L).orElseThrow(RuntimeException::new);
        return convert(customer);
    }
}
