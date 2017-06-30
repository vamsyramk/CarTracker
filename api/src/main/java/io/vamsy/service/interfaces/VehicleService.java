package io.vamsy.service.interfaces;

import io.vamsy.entity.Vehicle;

import java.util.List;

/**
 * Created by vamsyramk on 6/26/2017.
 */
public interface VehicleService {
    List<Vehicle> findAll();
    Vehicle findOne(String id);
    void create(List<Vehicle> vehicles);
    Vehicle update(String id, Vehicle emp);
    void delete(String id);

}
