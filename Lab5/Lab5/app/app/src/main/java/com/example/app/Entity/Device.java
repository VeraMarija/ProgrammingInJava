package com.example.app.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Data
@NoArgsConstructor
@Entity
@Table(name= "device")
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    @Column(name = "id")
    private Long id;

    @OneToOne
    @JoinColumn(name= "client_id", referencedColumnName = "id", unique = true)
    private Client client;


    public Device(Client client) {
        this.client = client;
    }



}
