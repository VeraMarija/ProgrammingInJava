package com.example.SpringBootRestApi.Service;

import com.example.SpringBootRestApi.Models.Client;
import com.example.SpringBootRestApi.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getClients(){
        return new ArrayList<>(clientRepository.findAll());
    }

    public Client saveClient(Client client){
        return clientRepository.save(client);
    }



}
