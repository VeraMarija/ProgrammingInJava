package com.example.app.Controller;

import com.example.app.Entity.Measurement;
import com.example.app.Service.MeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Month;
import java.util.LinkedHashMap;
import java.util.List;

@RestController
@RequestMapping("/measurement")
public class MeasurementController {

    @Autowired
    private final MeasurementService service;


    public MeasurementController(MeasurementService service) {
        this.service = service;
    }

    @GetMapping
    ResponseEntity<List<Measurement>> getMeasurements(){
        try {
            return ResponseEntity.ok(service.getMeasurements());
        }catch ( Exception exception){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    ResponseEntity<Measurement> addMeasurement(@RequestBody Measurement measurement){
        return ResponseEntity.ok(service.saveMeasurements(measurement));
    }

    @GetMapping ("/total/{yyear}")
    ResponseEntity<String> findByYearTotalConsumption(@PathVariable Integer yyear){
        return ResponseEntity.ok("GODINA " + yyear + " ---- UKUPNA POTROSNJA : " + service.getByYear(yyear));
    }

    @GetMapping("/listMonths/{yyear}")
    ResponseEntity<LinkedHashMap<String,Long>> allMonthsByYearTotalConsumption(@PathVariable Integer yyear){
        LinkedHashMap<String, Long> linkedHashMap = service.listMonthsByYear(yyear);
        return ResponseEntity.ok(linkedHashMap);
    }

    @GetMapping("/month/{yyear}")
    ResponseEntity<String>findMonthInYearConsumption(@PathVariable Integer yyear,
                                          @RequestParam(required = false) Integer mmonth) throws Exception{
        Long amount = service.findMonthInYear(yyear,mmonth);
        try{
            return ResponseEntity.ok("godina: " + yyear + " mjesec: " + Month.of(mmonth) + "ukupna potrosnja: " + amount );
        }catch(Exception e){
            return ResponseEntity.ok("krivi url parametri");
        }
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Long> deleteMeasurement(@PathVariable Long id) {

        var isRemoved = service.deleteMeasurement(id);

        if (!isRemoved) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(id, HttpStatus.OK);
    }


}
