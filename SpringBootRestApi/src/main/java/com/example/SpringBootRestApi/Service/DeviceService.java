package com.example.SpringBootRestApi.Service;


import com.example.SpringBootRestApi.Models.Device;
import com.example.SpringBootRestApi.Repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;


import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DeviceService {

    @Autowired
    private DeviceRepository deviceRepository;


    public List<Device> getDevices(){
        return new ArrayList<>(deviceRepository.findAll());
    }


    public Device saveDevice(Device device) throws HttpStatusCodeException {
        Device d = new Device(device.getIntMonth(),device.getIntYear());
        deviceRepository.save(d);
        return d;
    }



    public Optional<Device> getDeviceById(Long id){
        Optional<Device> deviceOptional = deviceRepository.findById(id);
        return deviceOptional;
    }


    public ResponseEntity<HttpStatus> deleteById(Long id) {
        try {
            deviceRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    public ResponseEntity<HttpStatus> updateDevice
                (Long id,Integer intMonth,Integer intYear,Integer energyConsumption){
        Optional<Device> deviceOptional = deviceRepository.findById(id);
        if(deviceOptional.isPresent()){
            Device _device = deviceOptional.get();
            if(intMonth!=null) {
                _device.setIntMonth(intMonth);
                _device.setMonth(intMonth);
            }
            if(intYear!=null) {
                _device.setIntYear(intYear);
                _device.setYear(intYear);
            }
            if(energyConsumption!=null)
                _device.setEnergyConsumption(energyConsumption);

            deviceRepository.save(_device);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
