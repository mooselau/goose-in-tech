package demo.jpa.entity;

import javax.persistence.Column;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import lombok.Getter;
import lombok.Setter;


@Getter
public class BaseEntity {
    // ID cannot be in base, otherwise service errors "no id specified for entity"
    @Column
    protected Long timeCreated;
    @Column
    protected Long timeUpdated;
    @Setter
    @Column
    protected Boolean isDeleted = false;

    @PrePersist
    public void prePersist() {
        if (timeCreated == null) {
            timeCreated = System.currentTimeMillis();
        }
        if (timeUpdated == null) {
            timeUpdated = System.currentTimeMillis();
        }
    }

    @PreUpdate
    public void preUpdate() {
        timeUpdated = System.currentTimeMillis();
    }
}
