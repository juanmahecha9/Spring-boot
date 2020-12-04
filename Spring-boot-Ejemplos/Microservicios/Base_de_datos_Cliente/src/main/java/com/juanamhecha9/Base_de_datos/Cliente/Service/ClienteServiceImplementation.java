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
public class ClienteServiceImplementation implements  ClienteService{

    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public Cliente getClienteById(int id) {
        Optional<Cliente> clientedb = this.clienteRepository.findById(id);

        if(clientedb.isPresent()){
            return clientedb.get();
        } else {
            throw new ResourceNotFoundException("Registro no exixtente");
        }
    }

    @Override
    public List<Cliente> getAllCliente() {
        return this.clienteRepository.findAll();
    }
}
