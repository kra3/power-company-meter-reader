package in.kra3.energy.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Arun on 10-Jan-17.
 */
@Entity
@Table(name = "profile",
        uniqueConstraints = @UniqueConstraint(columnNames = {"profile", "month"}))
public class Profile extends AbstractEntity {
    @NotNull
    private String profile;

    @NotNull
    @Column(length = 3)
    @Size(max = 3)
    private String month;

    @NotNull
    private Double fraction;

    public Profile() {
    }

    public Profile(String profile, String month, Double fraction) {
        this.profile = profile;
        this.month = month;
        this.fraction = fraction;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public Double getFraction() {
        return fraction;
    }

    public void setFraction(Double fraction) {
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
            - sum of all fraction for a profile per year is 1 (needs em)
     */
}
