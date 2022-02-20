package demo.entrypoint;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import demo.entity.Employee;
import demo.repository.EmployeeRepository;
import lombok.var;


/**
 * @DataJpaTest is used to test JPA layer
 * check this link: https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/test/autoconfigure/orm
 * /jpa/DataJpaTest.html
 */
@DataJpaTest
public class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void testFindAllByName() {
        prepareData();
        var employees = employeeRepository.findAllByName("Akon");
        assertEquals(1, employees.size());
    }

    private void prepareData() {
        var employee = new Employee();
        employee.setName("Akon");
        employee.setAge(20);
        var savedEmployee = employeeRepository.save(employee);
        assertNotNull((savedEmployee));
        assertEquals("Akon", savedEmployee.getName());
        assertEquals(20, savedEmployee.getAge());
    }

}
