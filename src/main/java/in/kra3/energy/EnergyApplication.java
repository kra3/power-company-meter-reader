package in.kra3.energy;

import in.kra3.energy.repositories.MeterReadingRepository;
import in.kra3.energy.repositories.ProfileRepository;
import in.kra3.energy.validators.MeterReadingValidator;
import in.kra3.energy.validators.ProfileValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.core.event.ValidatingRepositoryEventListener;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
public class EnergyApplication extends RepositoryRestConfigurerAdapter{
    ProfileRepository profileRepository;
    MeterReadingRepository meterReadingRepository;

    @Autowired
    public void setProfileRepository(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Autowired
    public void setMeterReadingRepository(MeterReadingRepository meterReadingRepository) {
        this.meterReadingRepository = meterReadingRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(EnergyApplication.class, args);
    }

    @Override
    public void configureValidatingRepositoryEventListener(ValidatingRepositoryEventListener validatingListener) {
        ProfileValidator profileValidator = new ProfileValidator(profileRepository);
        MeterReadingValidator meterReadingValidator = new MeterReadingValidator(meterReadingRepository, profileRepository);

        validatingListener.addValidator("beforeCreate", profileValidator);
        validatingListener.addValidator("beforeSave", profileValidator);
        validatingListener.addValidator("beforeCreate", meterReadingValidator);
        validatingListener.addValidator("beforeSave", meterReadingValidator);
    }

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        super.configureRepositoryRestConfiguration(config);
        config.setBasePath("/api");
    }
}
