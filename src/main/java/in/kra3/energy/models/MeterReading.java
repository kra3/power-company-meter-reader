package in.kra3.energy.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created by Arun on 10-Jan-17.
 */
@Entity
public class MeterReading extends AbstractEntity {
    @NotNull
    private Long connectionId;

    @NotNull
    private String profile;

    @NotNull
    @Column(length = 3)
    @Size(max = 3)
    @Pattern(
            regexp = "^(JAN|FEB|MAR|APR|MAY|JUN|JUL|AUG|SEP|OCT|NOV|DEC)$",
            flags = Pattern.Flag.CASE_INSENSITIVE,
            message = "Invalid month")
    private String month;

    @NotNull
    private Long reading;

    public MeterReading() {
    }

    public MeterReading(Long connectionId, String profile, String month, Long reading) {
        this.connectionId = connectionId;
        this.profile = profile;
        this.month = month;
        this.reading = reading;
    }

    public Long getConnectionId() {
        return connectionId;
    }

    public void setConnectionId(Long connectionId) {
        this.connectionId = connectionId;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public Long getReading() {
        return reading;
    }

    public void setReading(Long reading) {
        this.reading = reading;
    }

    @Override
    public String toString() {
        return "MeterReading{" +
                "id=" + getId() +
                ", connectionId=" + connectionId +
                ", profile='" + profile + '\'' +
                ", month='" + month + '\'' +
                ", reading=" + reading +
                '}';
    }
}
