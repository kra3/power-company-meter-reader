package in.kra3.energy.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * Created by Arun on 10-Jan-17.
 */
@Entity
public class Profile extends AbstractUniqueMonthYear {
    @NotNull
    private String profile;

    @NotNull
    private BigDecimal fraction;

    public BigDecimal getFraction() {
        return fraction;
    }

    public void setFraction(BigDecimal fraction) {
        this.fraction = fraction;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "id=" + getId() +
                ", profile='" + profile + '\'' +
                ", fraction=" + fraction +
                '}';
    }

    /*
        @todo: validations
            - date & profile is unique (needs em)
            - sum of all fraction for a profile per year is 1 (needs em)
     */
}
