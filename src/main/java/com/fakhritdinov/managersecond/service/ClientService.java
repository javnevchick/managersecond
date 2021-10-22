package com.fakhritdinov.managersecond.service;

import com.fakhritdinov.managersecond.model.Client;
import com.fakhritdinov.managersecond.repositiry.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    private final ClientRepository clientRepository;
    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client findById(Integer id) {
       return clientRepository.getById(id);
    }

    public Client findByName(String name) {
        return clientRepository.findClientByName(name);
    }

    public Client findByPassport(String passport) {
        return clientRepository.findClientByPassport(passport);
    }

    public Client findByContactNumber(String contactNumber) {
        return clientRepository.findClientByContactNumber(contactNumber);
    }

    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    public Client saveClient(Client client) {
       return clientRepository.save(client);
    }

    /*@Query("select c from Client c where c.name = :name")
    Client findByName(@Param("name") String name);*/
}
