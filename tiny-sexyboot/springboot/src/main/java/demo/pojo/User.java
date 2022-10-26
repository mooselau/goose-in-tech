package demo.pojo;

import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Component
public class User {
    private Long id;
    private String userName = "user_name_1";
    private String note = "note_1";

    @PostConstruct
    public void init() {
        this.id = 2L;
    }
}
