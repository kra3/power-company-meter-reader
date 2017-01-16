package in.kra3.energy.jobs;

import in.kra3.energy.repositories.MeterReadingRepository;
import in.kra3.energy.repositories.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by kra3 on 1/15/17.
 */
@Component
public class ProcessCSV {
    private ProfileRepository profileRepository;
    private MeterReadingRepository meterReadingRepository;

    @Autowired
    public ProcessCSV(ProfileRepository profileRepository, MeterReadingRepository meterReadingRepository) {
        this.profileRepository = profileRepository;
        this.meterReadingRepository = meterReadingRepository;
    }

    @Scheduled(fixedDelay = 5000)
    public void processCSV(){

    }

}
