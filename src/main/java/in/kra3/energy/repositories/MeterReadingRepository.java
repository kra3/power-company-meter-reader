package in.kra3.energy.repositories;

import in.kra3.energy.models.MeterReading;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by Arun on 10-Jan-17.
 */
@Repository
public interface MeterReadingRepository extends CrudRepository<MeterReading, Long> {
    MeterReading findByMonth(@Param("month") String month);

    MeterReading findByProfileAndMonth(@Param("profile") String profile, @Param("month") String month);
}
