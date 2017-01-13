package in.kra3.energy.models;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 * Created by kra3 on 1/13/17.
 */
@Component
public class ProfileValidator implements Validator {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public boolean supports(Class<?> aClass) {
        return Profile.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
//        errors.rejectValue("profile", "needs value");
    }

}
