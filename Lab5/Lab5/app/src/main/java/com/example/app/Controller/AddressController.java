package com.example.app.Controller;


import com.example.app.Entity.Address;
import com.example.app.Entity.Client;
import com.example.app.Service.AddressService;
import com.example.app.Service.ClientService;
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
    ResponseEntity<List<Address>> getAddresses(){
        try {
            return ResponseEntity.ok(addressService.getAddresses());
        }catch ( Exception exception){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(path="")
    ResponseEntity<Address> addAddress(@RequestBody Address address){
       return ResponseEntity.ok(addressService.saveAddress(address));

    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Long> deleteAddress(@PathVariable Long id) {

        var isRemoved = addressService.deleteAddress(id);

        if (!isRemoved) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(id, HttpStatus.OK);
    }





}
