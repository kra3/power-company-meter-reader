package in.kra3.energy.repositories;

import in.kra3.energy.models.Profile;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by Arun on 10-Jan-17.
 */
@Repository
public interface ProfileRepository extends CrudRepository<Profile, Long>, EntityManagerAwareRepo {
    @Query(value = "select new map(sum(p.fraction) as totalOfFractions, count(p.id) as numberOfFractions) from Profile p where p.profile = :profile")
    Map getFractionsForProfile(@Param("profile") String profile);

    List<Profile> findByProfile(@Param("profile") String profile);
}