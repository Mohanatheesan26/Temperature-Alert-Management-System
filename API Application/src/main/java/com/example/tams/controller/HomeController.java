package com.example.tams.controller;

import com.example.tams.modal.Reading;
import com.example.tams.modal.Sensor;
import com.example.tams.service.ReadingService;
import com.example.tams.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeController {

    @Autowired
    ReadingService readingService;

    @Autowired
    SensorService sensorService;

    @GetMapping("/readings")
    public List<Reading> getSensorData(){
        return readingService.getAllData();
    }

    @GetMapping("/readings/{id}")
    public List<Reading> getSensorData(@PathVariable int id){
        return readingService.getOneData(id);
    }

    @GetMapping("/sensors")
    public List<Sensor> getSensors(){
        return sensorService.getSensors();
    }

    @GetMapping("/sensors/{id}")
    public String getOneSensor(@PathVariable int id){
        Sensor sensor = sensorService.getOneSensor(id);
        return sensor.getName();
    }

}
