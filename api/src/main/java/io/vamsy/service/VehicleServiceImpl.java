package io.vamsy.service;

import io.vamsy.entity.Vehicle;
import io.vamsy.repository.interfaces.VehicleRespository;
import io.vamsy.service.interfaces.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by vamsyramk on 6/26/2017.
 */
@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    VehicleRespository repository;

    public List<Vehicle> findAll() {
        return repository.findAll();
    }

    public Vehicle findOne(String vin) {
        return repository.findOne(vin);
    }

    @Transactional
    public void create(List<Vehicle> vehicles) {
        for(Vehicle vehicle:vehicles){
            Vehicle existing = repository.findOne(vehicle.getVin());
            if(existing == null){
                repository.create(vehicle);
            }else{
                repository.update(vehicle.getVin(),vehicle);
            }
        }
    }

    @Transactional
    public Vehicle update(String vin, Vehicle veh) {

        return repository.update(vin,veh);
    }

    public void delete(String id) {

    }
}
