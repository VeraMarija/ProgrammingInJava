package com.example.SpringBootRestApi.Controller;


import com.example.SpringBootRestApi.Models.Address;
import com.example.SpringBootRestApi.Service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path= "/addresses")
public class AddressController {

    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService){
        this.addressService = addressService;
    }

    @GetMapping
    private ResponseEntity<List<Address>> getAddresses(){
        try {
            return ResponseEntity.ok(addressService.getAddresses());
        }catch ( Exception exception){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(path="")
    private ResponseEntity<Address> addAddress(@RequestBody Address address){
        return ResponseEntity.ok(addressService.saveAddress(address));

    }





}
