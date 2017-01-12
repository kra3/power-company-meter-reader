package in.kra3.energy.domain;

import javax.persistence.*;
import java.util.Calendar;

/**
 * Created by kra3 on 1/13/17.
 */
@MappedSuperclass
public class AbstractUniqueMonthYear {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // @ToDo: build validator
    @Temporal(TemporalType.DATE)
    private Calendar date;  // store year and month; and is unique.

    public AbstractUniqueMonthYear() {
    }

//    public AbstractUniqueMonthYear(String year, String month) {
//        // @todo: build a date here
//    }

    public Long getId() {
        return id;
    }

    @Override
    public int hashCode() {
        return id == null? 0: id.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(this.id == null || o == null || !(this.getClass().equals(o.getClass()))) return false;
        AbstractUniqueMonthYear that = (AbstractUniqueMonthYear) o;
        return this.id.equals(that.getId());
    }
}
