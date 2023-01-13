package com.example.app;
import com.example.app.Entity.Address;
import com.example.app.Entity.Client;
import com.example.app.Entity.Device;
import com.example.app.Entity.Measurement;
import com.example.app.Repository.AddressRepository;
import com.example.app.Repository.ClientRepository;
import com.example.app.Repository.DeviceRepository;
import com.example.app.Repository.MeasurementRepository;
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

    private final MeasurementRepository measurementRepository;

    public MyRunner(
            ClientRepository clientRepository,
            AddressRepository addressRepository,
            DeviceRepository deviceRepository,
            MeasurementRepository measurementRepository) {
        this.clientRepository = clientRepository;
        this.addressRepository=addressRepository;
        this.deviceRepository = deviceRepository;
        this.measurementRepository = measurementRepository;
    }
    @Override
    public void run(String... args) throws Exception {
        Address address1 = new Address("Croatia","Split","Mazuraniceva 2");
        Address address2 = new Address("Croatia","Zagreb","Bana Jelacica 2");
        Address address3 = new Address("Croatia","Zadar","Zvonimirova 10");
        addressRepository.save(address1);
        addressRepository.save(address2);
        addressRepository.save(address3);

        Client client1 = new Client("Ana","Anic",address1);
        Client client2 = new Client("Marija","Maric",address2);
        Client client3 = new Client("Miro","Miric",address3);
        clientRepository.save(client1);
        clientRepository.save(client2);
        clientRepository.save(client3);

        Device device1= new Device(client1);
        Device device2 = new Device(client2);
        Device device3 = new Device(client3);
        deviceRepository.save(device1);
        deviceRepository.save(device2);
        deviceRepository.save(device3);

        Measurement measurement1=new Measurement(1,2023,device1);
        Measurement measurement2 = new Measurement(1,2023,device1);
        Measurement measurement3 = new Measurement(2,2023,device1);
        Measurement measurement4 = new Measurement(1,2023,device2);
        Measurement measurement5 = new Measurement(5,2022,device3);
        measurementRepository.save(measurement1);
        measurementRepository.save(measurement2);
        measurementRepository.save(measurement3);
        measurementRepository.save(measurement4);
        measurementRepository.save(measurement5);




    }
}