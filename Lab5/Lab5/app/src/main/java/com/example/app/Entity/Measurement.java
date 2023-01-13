package com.example.app.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.Month;
import java.time.Year;
import java.util.HashSet;

@Data
@NoArgsConstructor
@Entity
@Table(name="measurement")
public class Measurement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    @Column(name = "id")
    private Long id;

    private Long amount;

    @Column(name = "lower_value")
    private static Integer lowerValue;

    @Column(name = "upper_value")
    private static Integer upperValue;

    private String mmonth;

    private Integer yyear;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "device_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Device device;




    public Measurement(Integer mmonth, Integer yyear, Device device) {
        this.lowerValue = 0;
        this.upperValue = 10000;
        this.mmonth = Month.of(mmonth).toString();
        this.yyear = yyear;
        this.device = device;
        this.amount =  Math.round((Math.random() * (10000 - 1)) + 1);
    }
}
