package com.juanamhecha9.Base_de_datos.Cliente.Service;

import com.juanamhecha9.Base_de_datos.Cliente.Model.Cliente;
import com.juanamhecha9.Base_de_datos.Cliente.Repository.ClienteRepository;
import com.juanamhecha9.Base_de_datos.Exception.Mensaje;
import com.juanamhecha9.Base_de_datos.Exception.ResourceNotFoundException;
import org.hibernate.mapping.Any;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ClienteServiceImplementation implements ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public Cliente getClienteById(int id) {
        Optional<Cliente> clientedb = this.clienteRepository.findById(id);

        if (clientedb.isPresent()) {
            return clientedb.get();
        } else {
            throw new ResourceNotFoundException("Registro no exixtente");
        }
    }

    @Override
    public List<Cliente> getAllCliente() {
        return this.clienteRepository.findAll();
    }

    @Override
    public Cliente createCliente(Cliente cliente) {
        return this.clienteRepository.save(cliente);
    }

    @Override
    public Cliente updateCliente(Cliente cliente) {
        Optional<Cliente> clientDb = this.clienteRepository.findById(cliente.getId());

        if (clientDb.isPresent()) {

            Cliente clienteUpdate = clientDb.get();
            clienteUpdate.setId(cliente.getId());
            clienteUpdate.setCorreo(cliente.getCorreo());
            clienteUpdate.setNombre(cliente.getNombre());

            clienteRepository.save(clienteUpdate);
            return clienteUpdate;
        } else {
            throw new ResourceNotFoundException("Registro no encontrado por el ID : " + cliente.getId());
        }
    }

    @Override
    public void deleteCliente(int id) {
        Optional<Cliente> cliente = this.clienteRepository.findById(id);
        if (cliente.isPresent()) {
            this.clienteRepository.delete(cliente.get());
        } else {
            throw new ResourceNotFoundException("Registro no encontrado por el ID :" + id);
        }
    }
}
