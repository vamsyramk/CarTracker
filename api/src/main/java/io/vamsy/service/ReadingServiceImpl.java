package io.vamsy.service;

import io.vamsy.entity.Alert;
import io.vamsy.entity.Reading;
import io.vamsy.entity.Tire;
import io.vamsy.entity.Vehicle;
import io.vamsy.repository.interfaces.ReadingRepository;
import io.vamsy.repository.interfaces.VehicleRespository;
import io.vamsy.service.interfaces.ReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vamsyramk on 6/28/2017.
 */
@Service
public class ReadingServiceImpl implements ReadingService {
    public static final String RULE1 = "Rule1";
    public static final String RULE2 = "Rule2";
    public static final String RULE3 = "Rule3";
    public static final String RULE4 = "Rule4";
    public static final String HIGH = "HIGH";
    public static final String MEDIUM = "MEDIUM";
    public static final String LOW = "LOW";


    @Autowired
    ReadingRepository readingRepository;

    @Autowired
    VehicleRespository vehicleRespository;

    @Transactional
    public Reading ingest(Reading reading) {
        Vehicle existingVehicle = vehicleRespository.findOne(reading.getVin());
        Tire tire = reading.getTires();
        List<Alert> alerts = new ArrayList<Alert>();
        if(existingVehicle!=null){
            if(reading.getEngineRpm() > existingVehicle.getRedlineRpm()){
                Alert alert = new Alert();
                alert.setRule(RULE1);
                alert.setPriority(HIGH);
                alerts.add(alert);
                readingRepository.create(alert);
            }
            if(reading.getFuelVolume() < (existingVehicle.getMaxFuelVolume()%10)){
                Alert alert = new Alert();
                alert.setRule(RULE2);
                alert.setPriority(MEDIUM);
                alerts.add(alert);
                readingRepository.create(alert);
            }
            if((tire.getFrontLeft()<32 || tire.getFrontLeft()>36)||(tire.getFrontRight()<32 || tire.getFrontRight()>36)
                    ||(tire.getRearLeft()<32 || tire.getRearLeft()>36)||(tire.getRearRight()<32 || tire.getRearLeft()>36)){

                Alert alert = new Alert();
                alert.setRule(RULE3);
                alert.setPriority(LOW);
                alerts.add(alert);
                readingRepository.create(alert);
            }
            if(reading.isEngineCoolantLow() || reading.isCheckEngineLightOn()){
                Alert alert = new Alert();
                alert.setRule(RULE4);
                alert.setPriority(LOW);
                alerts.add(alert);
                readingRepository.create(alert);
            }
        }
        reading.setAlerts(alerts);
        return readingRepository.ingest(reading);
    }
}
