package in.kra3.energy.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created by Arun on 10-Jan-17.
 */
@Entity
public class MeterReading extends AbstractUniqueMonthYear {
    @Column(unique = true)
    private Long connectionId;
    private String profile;
    private String month;
    private long reading;

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

    public long getReading() {
        return reading;
    }

    public void setReading(long reading) {
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
