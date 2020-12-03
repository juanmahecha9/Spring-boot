package net.javaguides.springboot.clientes.service;

import net.javaguides.springboot.clientes.model.Client;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClientService {
    Client createClient(Client client);

    Client updateClient(Client client);

    List<Client> getAllClient();

    Client getClientById(long clientId);

    void deleteClient(long id);
}
