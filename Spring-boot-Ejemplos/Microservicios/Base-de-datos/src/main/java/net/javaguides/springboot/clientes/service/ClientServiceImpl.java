package net.javaguides.springboot.clientes.service;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.clientes.model.Client;

import net.javaguides.springboot.clientes.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ClientServiceImpl implements ClientService{

    @Autowired
    private ClientRepository clientRepository;


    @Override
    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client updateClient(Client client) {
       Optional<Client> clientDb = this.clientRepository.findById(client.getId());

        if(clientDb.isPresent()){

            Client clientUpdate = clientDb.get();
            clientUpdate.setId(client.getId());
            clientUpdate.setCorreo(client.getCorreo());
            clientUpdate.setNombre(client.getNombre());

            clientRepository.save(clientUpdate);
            return clientUpdate;
        }  else{
            throw  new ResourceNotFoundException("Registro no encontrado por el ID : " + client.getId());
        }
    }

    @Override
    public List<Client> getAllClient() {
        return this.clientRepository.findAll();
    }

    @Override
    public Client getClientById(long clientId) {
        Optional<Client> clientDb = this.clientRepository.findById(clientId);

        if (clientDb.isPresent()){
            return clientDb.get();
        } else{
            throw  new ResourceNotFoundException("Registro no encontrado por el ID : " + clientId);
        }
    }

    @Override
    public void deleteClient(long id) {
        Optional<Client> clientDb = this.clientRepository.findById(id);
        if(clientDb.isPresent()) {
            this.clientRepository.delete(clientDb.get());
        }else {
            throw new ResourceNotFoundException("Record not found with id : " + id);
        }
    }


}

