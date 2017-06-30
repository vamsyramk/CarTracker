package io.vamsy.repository.interfaces;

import io.vamsy.entity.Vehicle;

import java.util.List;

/**
 * Created by vamsyramk on 6/27/2017.
 */
public interface VehicleRespository {

    List<Vehicle> findAll();
    Vehicle findOne(String vin);
    void create(Vehicle vehicle);
    Vehicle update(String id, Vehicle vehicle);
    void delete(String id);
}
