package in.kra3.energy.repositories;

import in.kra3.energy.models.Profile;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Arun on 10-Jan-17.
 */
@Repository
public interface ProfileRepository extends CrudRepository<Profile, Long>, EntityManagerAwareRepo {
    @Query("select SUM(fraction), COUNT(*) from Profile where profile = :profile")
    List<Integer[]> getFractionsForProfile(String profile);
}