package in.kra3.energy.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by Arun on 10-Jan-17.
 */
@RepositoryRestResource(collectionResourceRel = "profile", path = "profile")
public interface ProfileRepository extends CrudRepository<Profile, Long> {
}