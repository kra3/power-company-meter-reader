package in.kra3.energy.repositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by kra3 on 1/13/17.
 */
public class EntityManagerAwareRepoImpl implements EntityManagerAwareRepo {
    @PersistenceContext
    private EntityManager em;

    public void setEntityManager(EntityManager em) {
        this.em = em;
    }
}
