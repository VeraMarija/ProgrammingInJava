package com.example.app.Service;

import com.example.app.Entity.Client;
import com.example.app.Entity.Device;
import com.example.app.Entity.Measurement;
import com.example.app.Repository.MeasurementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Month;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;

@Service
public class MeasurementService {

    @Autowired
    private MeasurementRepository repository;

    public List<Measurement> getMeasurements(){
        return new ArrayList<>(repository.findAll());
    }

    public Measurement saveMeasurements(Measurement measurement){
        repository.save(measurement);
        return repository.save(measurement);
    }

    public boolean deleteMeasurement(Long id){
        Optional<Measurement> measurementOptional = repository.findById(id);
        if(measurementOptional.isPresent()) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    public Long getByYear(Integer year){
        var ref = new Object() {
            Long amount = 0L;
        };
        List<Measurement> measurements = repository.findByYyear(year);
        if (!measurements.isEmpty()){
            measurements.forEach(measurement -> {
                ref.amount += measurement.getAmount();
            });
        return  ref.amount;
        }
        return ref.amount;
    }

    public LinkedHashMap<String,Long> listMonthsByYear (Integer year) {
        LinkedHashMap<String, Long> linkedHashMap = new LinkedHashMap<String, Long>();
        for(int i=1;i<=12;++i){
            var ref = new Object() {
                Long amount = 0L;
            };
            List<Measurement> measurements = repository.findByMmonthAndYyear(String.valueOf(Month.of(i)),year);
            if(!measurements.isEmpty()){
                measurements.forEach(measurement -> {
                    ref.amount+=measurement.getAmount();
                });
                linkedHashMap.put(String.valueOf(Month.of(i)), ref.amount);
            }
            else {
                linkedHashMap.put(String.valueOf(Month.of(i)),ref.amount);
            }
        }
        return linkedHashMap;
    }

    public Long findMonthInYear(Integer year, Integer month){
        var ref = new Object(){
            Long amount = 0L;
        };
        List<Measurement> measurements = repository.findByMmonthAndYyear(String.valueOf(Month.of(month)),year);
        if(!measurements.isEmpty()){
            measurements.forEach(measurement -> {
                ref.amount += measurement.getAmount();
            });
        return ref.amount;
        }
        return ref.amount;
    }


}
