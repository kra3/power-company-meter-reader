package in.kra3.energy.controller;

import in.kra3.energy.domain.MeterReadingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by kra3 on 1/13/17.
 */
@RestController
@RequestMapping("/api/meter_reading")
public class MeterReadingController {
    private MeterReadingRepository meterReadingRepository;

    @Autowired
    public void setMeterReadingRepository(MeterReadingRepository meterReadingRepository) {
        this.meterReadingRepository = meterReadingRepository;
    }

    @RequestMapping(path="/month/{month}", method = RequestMethod.GET)
    public long consumptionForMonth(@PathVariable String month){
        return 100;  // @todo: implement
    }
}
