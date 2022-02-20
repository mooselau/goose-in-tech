package demo.vo;

import java.util.List;
import lombok.Data;


@Data
public class DemoCustomerVo {
    private String name;
    private String mobile;
    private String city;
    private String email;
    private String address;
    private List orders;
}
