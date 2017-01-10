package in.kra3.energy.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Arun on 10-Jan-17.
 */
@Entity
public class MeterReading {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private long connectionId;
    private String profile;
    private String month;
    private long reading;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getConnectionId() {
        return connectionId;
    }

    public void setConnectionId(long connectionId) {
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
                "id=" + id +
                ", connectionId=" + connectionId +
                ", profile='" + profile + '\'' +
                ", month='" + month + '\'' +
                ", reading=" + reading +
                '}';
    }
}
