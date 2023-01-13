package com.example.app.Service;


import com.example.app.Entity.Address;
import com.example.app.Entity.Client;
import com.example.app.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


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

    public boolean deleteClient(Long id){
        Optional<Client> clientOptional = clientRepository.findById(id);
        if(clientOptional.isPresent()) {
            clientRepository.deleteById(id);
            return true;
        }
        return false;
    }




}
