package com.example.app.Service;


import com.example.app.Entity.Device;
import com.example.app.Entity.Measurement;
import com.example.app.Repository.DeviceRepository;
import com.example.app.Repository.MeasurementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class DeviceService {

    @Autowired
    private DeviceRepository deviceRepository;

    @Autowired
    private MeasurementRepository measurementRepository;

    public List<Device> getDevices(){
        return new ArrayList<>(deviceRepository.findAll());
    }

    public Device saveDevice(Device device){
        deviceRepository.save(device);
        return deviceRepository.save(device);
    }
/*
    public Integer getByYear(Integer year){
        var ref = new Object() {
            Integer amount = 0;
        };
        List<Device> devices = deviceRepository.findDeviceByYyear(year);
        if(!devices.isEmpty()){
            devices.forEach(device -> {
                List<Measurement> measurements = measurementRepository.findMeasurementByDevice_Id(device.getId());
                ref.amount += measurements.stream().mapToInt(m -> Math.toIntExact(m.getAmount())).sum();
            });
           return ref.amount;
        }
        return 0;
    }


    public LinkedHashMap<Integer,Integer> listMonthsByYear (Integer year) {
        LinkedHashMap<Integer, Integer> linkedHashMap = new LinkedHashMap<Integer, Integer>();
        for(int i=1;i<=12;++i){
            var ref = new Object() {
                Integer amount = 0;
            };
            List<Device> devices = deviceRepository.findDeviceByMmonthAndYyear(i,year);
            if(!devices.isEmpty()){
                devices.forEach(device -> {
                    List<Measurement> measurements = measurementRepository.findMeasurementByDevice_Id(device.getId());
                    ref.amount += measurements.stream().mapToInt(m -> Math.toIntExact(m.getAmount())).sum();
                });
            }
            linkedHashMap.put(i, ref.amount);
        }
        return linkedHashMap;

    }
*/





}
