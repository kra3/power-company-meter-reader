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

    private Long consumption;  // calculate & save this later.

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

    public Long getConsumption() {
        return consumption;
    }

    public void setConsumption(Long consumption) {
        this.consumption = consumption;
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

    /*
        @todo: validations
            - each meter reading should be greater than previous months meter reading for connection
            - for corresponding profile there should be a match in profile table (with fraction)
            - validate consumption (ie., difference between readings)
              formulae: get total consumption for year (DEC - JAN of readings)
                        get that month's fraction
                        multiply them and find the 25% of the result as tolerance
                        consumption should fall in the range of [result-tolerance:result+tolerance]
              ps: needs entire years reading (or JAN * DEC reading ;)
                  should be done as a separate validation (not at insert) due to above requirement

     */
}
