package com.example.SpringBootRestApi.Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.Year;
import java.util.Random;

@Data
@NoArgsConstructor
@Entity
@Table(name= "device" ,
        uniqueConstraints = { @UniqueConstraint(name="UniqueYearAndMonth",
                            columnNames = {"month", "year"} ) })
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private Long id;
    @Column(name = "month")
    private String month  ;
    private Integer intMonth;
    @Column(name = "year")
    private String year;
    private Integer intYear;

    private Integer energyConsumption ;

    public Device(Integer intMonth,  Integer intYear){
        this.intMonth = intMonth;
        this.month = String.valueOf(Month.of(getIntMonth()));
        this.intYear = intYear;
        this.year = String.valueOf(Year.of(getIntYear()));
        this.energyConsumption =  (int) ((Math.random() * (9999)) + 1);
    }

    public void setMonth(Integer intMonth) {
        this.month = String.valueOf(Month.of(getIntMonth()));
    }

    public void setYear(Integer intYear) {
        this.year = String.valueOf(Year.of(getIntYear()));
    }
}