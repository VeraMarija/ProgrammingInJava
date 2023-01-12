package com.example.SpringBootRestApi.Controller;

import com.example.SpringBootRestApi.Models.Client;
import com.example.SpringBootRestApi.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/clients")
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }


    @GetMapping
    private ResponseEntity<List<Client>> getClients(){
        try {
            return ResponseEntity.ok(clientService.getClients());
        }catch ( Exception exception){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(path="")
    private ResponseEntity<Client> addClient(@RequestBody Client client){
        return ResponseEntity.ok(clientService.saveClient(client));

    }






}
