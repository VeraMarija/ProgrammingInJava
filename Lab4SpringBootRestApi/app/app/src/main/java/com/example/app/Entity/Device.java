package com.example.app.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
@Data
@NoArgsConstructor
@Entity
@Table(name= "device")
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private Long id;
    private Integer lowerValue;
    private Integer upperValue;
    private String energyConsumption ;
    public void setEnergyConsumption() {
        this.energyConsumption = String.valueOf(
                ((Math.random() * (getUpperValue() - getLowerValue())) + getLowerValue())
                        + " kWh -- date and time: " + LocalDate.now() + " " + LocalTime.now());
    }

    public Device(Integer lowerValue, Integer upperValue){
        this.lowerValue = lowerValue;
        this.upperValue = upperValue;
        this.energyConsumption = String.valueOf(
                ((Math.random() * (getUpperValue() - getLowerValue())) + getLowerValue())
                + " kWh -- date and time: " + LocalDate.now() + " " + LocalTime.now());
    }

}
