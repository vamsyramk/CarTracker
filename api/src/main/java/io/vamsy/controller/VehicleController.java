package io.vamsy.controller;

import io.vamsy.entity.Vehicle;
import io.vamsy.service.interfaces.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by vamsyramk on 6/26/2017.
 */
@RestController
@RequestMapping(value = "/vehicles")
public class VehicleController {

    @Autowired
    VehicleService service;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Vehicle> findAll() {
        System.out.println("Reached findall");
        return service.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{vin}",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Vehicle findOne(@PathVariable("vin") String vin) {

        return service.findOne(vin);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Vehicle> create(@RequestBody List<Vehicle> veh) {

        service.create(veh);
        return null;
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void update(@RequestBody List<Vehicle> vehicles) {
        System.out.println("Reached update");
        service.create(vehicles);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{vin}")
    public void delete(@PathVariable("vin") String vin) {
        service.delete(vin);
    }
}
