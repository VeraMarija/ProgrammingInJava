package com.example.app.Service;


import com.example.app.Entity.Address;
import com.example.app.Entity.Device;
import com.example.app.Repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeviceService {

    @Autowired
    private DeviceRepository deviceRepository;

    public List<Device> getDevices(){
        return new ArrayList<>(deviceRepository.findAll());
    }

    public Device saveDevice(Device device){
        device.setEnergyConsumption();
        return deviceRepository.save(device);
        }



}
