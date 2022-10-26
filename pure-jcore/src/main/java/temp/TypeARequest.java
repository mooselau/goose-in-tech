package temp;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class TypeARequest extends AbstractRequest {
    private Integer type = 1;
    private String name = "typeA";

    public TypeARequest() {
        System.out.println("initing TypeARequest..");
    }

}
