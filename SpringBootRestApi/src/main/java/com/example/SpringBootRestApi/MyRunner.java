package com.example.SpringBootRestApi;

import com.example.SpringBootRestApi.Models.Address;
import com.example.SpringBootRestApi.Models.Client;
import com.example.SpringBootRestApi.Models.Device;
import com.example.SpringBootRestApi.Repository.AddressRepository;
import com.example.SpringBootRestApi.Repository.ClientRepository;
import com.example.SpringBootRestApi.Repository.DeviceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(MyRunner.class);
    private final ClientRepository clientRepository;
    private final AddressRepository addressRepository;
    private final DeviceRepository deviceRepository;

    public MyRunner(
            ClientRepository clientRepository,
            AddressRepository addressRepository,
            DeviceRepository deviceRepository) {
        this.clientRepository = clientRepository;
        this.addressRepository=addressRepository;
        this.deviceRepository = deviceRepository;
    }
    @Override
    public void run(String... args) throws Exception {
        /*Device device1= new Device(1,2022);
        deviceRepository.save(device1);
        Address address1 = new Address("Croatia","Split","Mazuraniceva 2",device1);
        addressRepository.save(address1);
        Client client1 = new Client("Ana","Anic",address1);
        clientRepository.save(client1);*/

    }
}