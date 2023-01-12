package com.example.SpringBootRestApi.Service;


import com.example.SpringBootRestApi.Models.Address;
import com.example.SpringBootRestApi.Repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
}
