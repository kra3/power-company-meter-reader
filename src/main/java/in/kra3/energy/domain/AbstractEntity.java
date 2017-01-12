package in.kra3.energy.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Created by kra3 on 1/13/17.
 */
@MappedSuperclass
public class AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

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
        AbstractEntity that = (AbstractEntity) o;
        return this.id.equals(that.getId());
    }
}
