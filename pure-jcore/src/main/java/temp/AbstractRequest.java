package temp;

import lombok.Getter;


@Getter
public abstract class AbstractRequest {
    private String id;
    private Integer type = 0;
    private String name = "abstractType";

    public AbstractRequest() {
        this.id = "myid";
        System.out.println("initing AbstractRequest..");
    }

    public AbstractRequest(String id) {
        this.id = id;
    }
}
