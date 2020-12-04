package com.juanamhecha9.Base_de_datos.Cliente.Service;

import com.juanamhecha9.Base_de_datos.Cliente.Model.Cliente;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClienteService {

    Cliente getClienteById(int id);

    List<Cliente>getAllCliente();

}
