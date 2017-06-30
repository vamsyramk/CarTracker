package io.vamsy.controller;

import io.vamsy.entity.Reading;
import io.vamsy.entity.Vehicle;
import io.vamsy.service.interfaces.ReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Created by vamsyramk on 6/27/2017.
 */
@RestController
@RequestMapping(value = "/readings")
public class ReadingController {

    @Autowired
    ReadingService service;

    @RequestMapping(method = RequestMethod.GET, value = "/{vin}",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Vehicle findOne(@PathVariable("vin") String vin) {
        return null;
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void create(@RequestBody Reading reading) {
        service.ingest(reading);
    }

}
