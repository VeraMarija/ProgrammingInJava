package com.example.app.Controller;

import com.example.app.Entity.Client;
import com.example.app.Service.ClientService;
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
    ResponseEntity<List<Client>> getClients(){
        try {
            return ResponseEntity.ok(clientService.getClients());
        }catch ( Exception exception){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(path="")
    ResponseEntity<Client> addClient(@RequestBody Client client){
        return ResponseEntity.ok(clientService.saveClient(client));

    }






}
