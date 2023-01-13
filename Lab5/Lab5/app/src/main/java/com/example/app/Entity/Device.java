package com.example.app.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;


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
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Client client;


    public Device(Client client) {
        this.client = client;
    }



}
