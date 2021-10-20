package com.fakhritdinov.managersecond.repositiry;

import com.fakhritdinov.managersecond.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClientRepository extends JpaRepository<Client, Integer> {

    Client findClientByName(String name);

    Client findClientByContactNumber(String contactNumber);

    Client findClientByPassport(String passport);

}
