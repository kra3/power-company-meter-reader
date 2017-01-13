package in.kra3.energy.repositories;

/**
 * Created by kra3 on 1/13/17.
 */
public class FractionsForProfile {
    Integer total;
    Integer count;

    public FractionsForProfile() {
    }

    public FractionsForProfile(Integer total, Integer count) {
        this.total = total;
        this.count = count;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "FractionsForProfile{" +
                "total=" + total +
                ", count=" + count +
                '}';
    }
}
