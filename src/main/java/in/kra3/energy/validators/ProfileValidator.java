package in.kra3.energy.validators;

/**
 * Created by kra3 on 1/14/17.
 */

import in.kra3.energy.models.Profile;
import in.kra3.energy.repositories.ProfileRepository;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Map;

@Component
public class ProfileValidator implements Validator {
    private ProfileRepository profileRepository;

    public ProfileValidator(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Profile.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Profile profile = (Profile) o;
        Map fractionsForProfile = profileRepository.getFractionsForProfile(profile.getProfile());
        Long numberOfFractions = (Long) fractionsForProfile.get("numberOfFractions");
        Double totalOfFractions = (Double) fractionsForProfile.get("totalOfFractions");

        if(numberOfFractions  == null){
            numberOfFractions = 0L;
        }

        if(totalOfFractions  == null){
            totalOfFractions = 0.0d;
        }

        // validation before saving 12th item.
        if (numberOfFractions == 11 && totalOfFractions != 1 - profile.getFraction()) {
            errors.reject("Sum of all fractions for a profile per year should be 1");
        }

        // validation while updating an item out of 12
        if (numberOfFractions == 12){
            double currentTotal = totalOfFractions;
            Profile oldProfile = profileRepository.findOne(profile.getId());

            if(currentTotal - oldProfile.getFraction() + profile.getFraction() != 1) {
                errors.reject("Sum of all fractions for a profile per year should be 1");
            }
        }

        // more than 12 entries (including current object)
        if (numberOfFractions > 11){
            errors.reject("More than 12 entries per profile is not allowed");
        }

        // fraction not summing up to 1
        if(totalOfFractions + profile.getFraction() > 1){
            errors.reject("fraction should sum up to 1.");
        }
    }
}
