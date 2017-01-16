package in.kra3.energy.controller;

import in.kra3.energy.Utils;
import in.kra3.energy.repositories.MeterReadingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by kra3 on 1/15/17.
 */
@RestController
@RequestMapping("/api/meterReadings")
public class MeterReadingController {
    private MeterReadingRepository meterReadingRepository;

    @Autowired
    public void setMeterReadingRepository(MeterReadingRepository meterReadingRepository) {
        this.meterReadingRepository = meterReadingRepository;
    }

    @RequestMapping("/getConsumptionForMonth")
    public Long getConsumptionForMonth(@RequestParam("month") String month) {
        Utils utils = Utils.getInstance();

        if(! utils.isValidMonth(month)){
            return 0L;
        }

        String prevMonth = utils.previousMonth(month);
        try {
            Long cur_reading = meterReadingRepository.findByMonth(month).getReading();
            Long prev_reading = meterReadingRepository.findByMonth(prevMonth).getReading();
            return prev_reading - cur_reading;
        }catch (NullPointerException e){
            return 0L;
        }
    }
}
