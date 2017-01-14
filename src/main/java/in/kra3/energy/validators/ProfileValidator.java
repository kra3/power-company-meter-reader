package in.kra3.energy.validators;

/**
 * Created by kra3 on 1/14/17.
 */

import in.kra3.energy.models.Profile;
import in.kra3.energy.repositories.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


@Component
public class ProfileValidator implements Validator {
    private ProfileRepository profileRepository;

    @Autowired
    public void setProfileRepository(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Profile.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Profile profile = (Profile) o;
        errors.reject("++++++++++++++++++++++>>>>>>>>>>>");
    }
}
