package com.juanamhecha9.Base_de_datos.Cliente.Controller;

import com.juanamhecha9.Base_de_datos.Cliente.Model.Cliente;
import com.juanamhecha9.Base_de_datos.Cliente.Service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>> getAllClientes(){
        return ResponseEntity.ok().body(this.clienteService.getAllCliente());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable int id, @RequestBody Cliente cliente){
        return ResponseEntity.ok().body(this.clienteService.getClienteById(id));
    }
}
