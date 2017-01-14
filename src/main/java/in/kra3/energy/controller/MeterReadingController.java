package in.kra3.energy.controller;

import in.kra3.energy.models.MeterReading;
import in.kra3.energy.repositories.MeterReadingRepository;
import in.kra3.energy.validators.MeterReadingValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

/**
 * Created by kra3 on 1/13/17.
 */
@RestController
@RequestMapping("/meterReadings")
public class MeterReadingController {
    private MeterReadingValidator meterReadingValidator;
    private MeterReadingRepository meterReadingRepository;

    public void setMeterReadingValidator(MeterReadingValidator meterReadingValidator) {
        this.meterReadingValidator = meterReadingValidator;
    }

    @Autowired
    public void setMeterReadingRepository(MeterReadingRepository meterReadingRepository) {
        this.meterReadingRepository = meterReadingRepository;
    }

    @RequestMapping(path="/month/{month}", method = RequestMethod.GET)
    public long consumptionForMonth(@PathVariable String month){
        return 100;  // @todo: implement
    }


    @RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
    public long save(@ModelAttribute("meterReading") MeterReading meterReading, BindingResult result){
        meterReadingValidator.validate(meterReading, result);

        if(result.hasErrors()){
            return 0;
        }else{
            meterReadingRepository.save(meterReading);
            return meterReading.getId();
        }
    }
}
