package com.example.app.Controller;

import com.example.app.Entity.Address;
import com.example.app.Entity.Device;
import com.example.app.Service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    private ResponseEntity<List<Device>> getDevices(){
        try {
            return ResponseEntity.ok(deviceService.getDevices());
        }catch ( Exception exception){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(path="")
    private ResponseEntity<Device> addDevice(@RequestBody Device device){
        return ResponseEntity.ok(deviceService.saveDevice(device));
    }


}
