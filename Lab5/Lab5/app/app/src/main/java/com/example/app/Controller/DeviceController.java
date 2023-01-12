package com.example.app.Controller;

import com.example.app.Entity.Address;
import com.example.app.Entity.Device;
import com.example.app.Entity.Measurement;
import com.example.app.Service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
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
    ResponseEntity<List<Device>> getDevices(){
        try {
            return ResponseEntity.ok(deviceService.getDevices());
        }catch ( Exception exception){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    ResponseEntity<Device> addDevice(@RequestBody Device device){
        return ResponseEntity.ok(deviceService.saveDevice(device));
    }

   /* @GetMapping("/{_year}")
    ResponseEntity<String> findByYear(@PathVariable Integer _year){
        return ResponseEntity.ok("GODINA " + _year + " ---- UKUPNA POTROSNJA : " + deviceService.getByYear(_year));
    }

    @GetMapping("/listMonths/{_year}")
    ResponseEntity<LinkedHashMap<Integer,Integer>> listMonthsByYear(@PathVariable Integer _year){
        LinkedHashMap<Integer, Integer> linkedHashMap = deviceService.listMonthsByYear(_year);
        return ResponseEntity.ok(linkedHashMap);
    }

*/


}
