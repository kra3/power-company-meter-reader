package in.kra3.energy.repositories;

import in.kra3.energy.models.MeterReading;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Arun on 10-Jan-17.
 */
@Repository
public interface MeterReadingRepository extends JpaRepository<MeterReading, Long> {

}
