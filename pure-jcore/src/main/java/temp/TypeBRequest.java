package temp;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class TypeBRequest extends AbstractRequest {
    private Integer type = 2;
    private String name = "typeB";
    private String time = "2020";
}
