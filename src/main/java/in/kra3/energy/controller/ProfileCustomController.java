package in.kra3.energy.controller;

import in.kra3.energy.models.Profile;
import in.kra3.energy.repositories.ProfileRepository;
import in.kra3.energy.validators.ProfileValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by kra3 on 1/14/17.
 */
@RestController
@RequestMapping("/profiles")
public class ProfileCustomController {
    private ProfileValidator profileValidator;
    private ProfileRepository profileRepository;

    @Autowired
    public void setProfileValidator(ProfileValidator profileValidator) {
        this.profileValidator = profileValidator;
    }

    @Autowired
    public void setProfileRepository(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
    public long save(@ModelAttribute("profile") Profile profile, BindingResult result){
        profileValidator.validate(profile, result);

        if(result.hasErrors()){
            return 0;
        }else{
            profileRepository.save(profile);
            return profile.getId();
        }
    }
}

