package org.example;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Random;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Sensor {

    private String name;
    private Double lowerValue;
    private Double upperValue;
    private String unit;

    public double randomGenerator() {
        Random result = new Random();
        return result.doubles(1, lowerValue, upperValue).toArray()[0];
    }

    public double randomGenerator(int factor){
        Random result = new Random();
        return result.doubles(1,lowerValue,upperValue).toArray()[0]*factor;
    }

}

