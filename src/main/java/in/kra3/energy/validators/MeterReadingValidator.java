package in.kra3.energy.validators;

import in.kra3.energy.models.MeterReading;
import in.kra3.energy.repositories.MeterReadingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by kra3 on 1/14/17.
 */
@Component
public class MeterReadingValidator implements Validator {
    private MeterReadingRepository meterReadingRepository;

    @Autowired
    public void setProfileRepository(MeterReadingRepository meterReadingRepository) {
        this.meterReadingRepository = meterReadingRepository;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return MeterReading.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        MeterReading meterReading = (MeterReading) o;
        errors.reject("++++++++++++++++++++++>>>>>>>>>>>");
    }
}
