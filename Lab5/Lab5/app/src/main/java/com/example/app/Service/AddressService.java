package com.example.app.Service;


import com.example.app.Entity.Address;
import com.example.app.Entity.Client;
import com.example.app.Repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public List<Address> getAddresses(){
        return new ArrayList<>(addressRepository.findAll());
    }

    public Address saveAddress(Address address){
        return addressRepository.save(address);
    }

    public boolean deleteAddress(Long id){
        Optional<Address> addressOptional = addressRepository.findById(id);
        if(addressOptional.isPresent()) {
            addressRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
