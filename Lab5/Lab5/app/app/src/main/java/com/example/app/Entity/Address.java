package com.example.app.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "country")
    private String country;
    @Column(name = "city")
    private String city;
    @Column(unique = true, name = "street")
    private String street;


    public Address(String country, String city, String street) {
        this.country = country;
        this.city = city;
        this.street = street;
        //this.device = device;
    }
}
