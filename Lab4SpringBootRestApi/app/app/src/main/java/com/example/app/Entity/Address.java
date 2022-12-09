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
    private Long id;
    private String country;
    private String city;
    @Column(unique = true)
    private String street;
    @OneToOne
    @JoinColumn(name= "device_id" , referencedColumnName = "id",unique = true)
    private Device device;

    public Address(String country, String city, String street,Device device) {
        this.country = country;
        this.city = city;
        this.street = street;
        this.device = device;
    }
}
