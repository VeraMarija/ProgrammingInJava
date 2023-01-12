package com.example.SpringBootRestApi.Controller;

import com.example.SpringBootRestApi.Models.Device;
import com.example.SpringBootRestApi.Service.DeviceService;
import com.example.SpringBootRestApi.exception.ApiRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/devices")
public class DeviceController {

    @Autowired
    private final DeviceService deviceService;

    public DeviceController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }



    @GetMapping
    public ResponseEntity<List<Device>>getDevices(){
      try{  if (deviceService.getDevices().isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(deviceService.getDevices(), HttpStatus.OK);
    } catch (Exception e) {
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
       /* if (deviceService.getDevices().isEmpty())
            return new ResponseEntity<>(deviceService.getDevices(),HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(deviceService.getDevices(), HttpStatus.OK);*/
    }



    @PostMapping(path="")
    public ResponseEntity<Device> addDevice(@RequestBody Device device){
        //Device dev1 = new Device(5,2000);
        try {
            return new ResponseEntity<>
                    (deviceService.saveDevice(device), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>
                    (HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable("id") Long id  ){
        return deviceService.deleteById(id);
    }



    @PutMapping(path="update/{id}")
    public ResponseEntity<HttpStatus> updateDevice(@PathVariable("id") Long id,
                                                   @RequestParam(required = false) Integer intMonth ,
                                                   @RequestParam(required = false) Integer intYear,
                                                   @RequestParam(required = false) Integer energyConsumption){
        return deviceService.updateDevice(id,intMonth,intYear,energyConsumption);
    }










}
