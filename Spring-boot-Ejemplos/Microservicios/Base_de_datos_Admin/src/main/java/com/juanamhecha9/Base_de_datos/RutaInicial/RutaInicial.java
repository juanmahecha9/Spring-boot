package com.juanamhecha9.Base_de_datos.RutaInicial;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class RutaInicial {

    @GetMapping
    public Model init() {
        Model model = new Model();
        return new Model("Juan David Mahecha Cruz", "CRUD MySQL, inicio de microservicios", "Dic 2020");
    }

}
