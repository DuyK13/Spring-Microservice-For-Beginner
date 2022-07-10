package c99.ams.userservice.entity;

import c99.ams.userservice.utils.enums.ERole;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * @author Duy Tran The
 * @version 0.1
 * @datetime 6/8/2021 10:15 AM
 */
@Embeddable
public class Role {

    @Enumerated(EnumType.STRING)
    private ERole name;

    public Role(ERole name) {
        this.name = name;
    }

    public Role() {
    }

    public ERole getName() {
        return name;
    }

    public void setName(ERole name) {
        this.name = name;
    }
}
