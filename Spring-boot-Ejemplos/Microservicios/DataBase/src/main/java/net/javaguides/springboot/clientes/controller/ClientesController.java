package net.javaguides.springboot.clientes.controller;

        import java.util.List;

        import net.javaguides.springboot.clientes.model.Client;
        import net.javaguides.springboot.clientes.service.ClientService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.http.HttpStatus;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.DeleteMapping;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.PathVariable;
        import org.springframework.web.bind.annotation.PostMapping;
        import org.springframework.web.bind.annotation.PutMapping;
        import org.springframework.web.bind.annotation.RequestBody;
        import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientesController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/clients")
    public  ResponseEntity<List<Client>> getAllClient(){
        return ResponseEntity.ok().body(this.clientService.getAllClient());
    }

    @GetMapping("/clients/{id}")
    public  ResponseEntity<Client> getClientById(@PathVariable long id){
        return ResponseEntity.ok().body(clientService.getClientById(id));
    }

}
