package in.kra3.energy;

import in.kra3.energy.models.MeterReading;
import in.kra3.energy.models.Profile;
import in.kra3.energy.repositories.MeterReadingRepository;
import in.kra3.energy.repositories.ProfileRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.ConstraintViolationException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EnergyApplicationTests {
    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private MeterReadingRepository meterReadingRepository;


    @Test
    public void uniquenessOfProfileAndMonth() {
        try {
            Profile p1 = new Profile("A", "JAN", .1);
            Profile p2 = new Profile("A", "FEB", .2);
            Profile p3 = new Profile("A", "JAN", .2);
            profileRepository.save(p1);
            profileRepository.save(p2);
            profileRepository.save(p3);
            Assert.fail("There should be only one entry per month per profile.");
        } catch (Exception e) {
            System.out.println("->>>>>>>>>>>" + e);
        }
    }

    @Test
    public void checkMeterReadingIsGreaterThanLastMonths() {
        try {
            MeterReading m1 = new MeterReading(1L, "A", "JAN", 10L);
            MeterReading m2 = new MeterReading(1L, "A", "FEB", 9L);
            meterReadingRepository.save(m1);
            meterReadingRepository.save(m2);
            Assert.fail("Meter reading can not be less than previous month.");
        } catch (Exception ignored) {
        }
    }

    @Test
    public void checkFractionExistsForMonth() {
        try {
            MeterReading m1 = new MeterReading(1L, "A", "DEC", 10L);
            meterReadingRepository.save(m1);
            Assert.fail("Corresponding fraction should exist for each month");
        } catch (Exception ignored) {
        }
    }

}
